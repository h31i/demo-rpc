package h31i.demorpc.server;


import h31i.demorpc.Request;
import h31i.demorpc.Response;
import h31i.demorpc.codec.Decoder;
import h31i.demorpc.codec.Encoder;
import h31i.demorpc.common.utils.ReflectionUtils;
import h31i.demorpc.transport.RequestHandler;
import h31i.demorpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


@Slf4j
public class RpcServer {

    /**
     * Server配置
     */
    private RpcServerConfig config;
    /**
     *
     */
    private TransportServer net;
    /**
     * 序列化
     */
    private Encoder encoder;
    /**
     * 反序列化
     */
    private Decoder decoder;
    /**
     * 暴露服务管理
     */
    private ServiceManager serviceManager;
    /**
     * 服务调用
     */
    private ServiceInvoker serviceInvoker;

    public RpcServer() {
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;
        //net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);

        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register( Class<T> interfaceClass, T bean){
        serviceManager.register(interfaceClass, bean);
    }

    public void start(){
        this.net.start();
    }

    public void stop(){
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream recive, OutputStream toResponse)  {

            Response resp = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(recive, recive.available());
                Request request = decoder.decode(inBytes, Request.class);

                log.info("get request:{}", request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis, request);
                resp.setData(ret);

            } catch (Exception e) {
                log.warn(e.getMessage(), e);
                resp.setCode(1);
                resp.setMessage("RPCServer got error:"
                        + e.getClass().getName()
                        + " : " + e.getMessage());
            }finally {
                try {
                    byte[] outBytes = encoder.encode(resp);
                    toResponse.write(outBytes);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }

        }
    };
}
