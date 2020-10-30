package h31i.demorpc.server;


import h31i.demorpc.codec.Decoder;
import h31i.demorpc.codec.Encoder;
import h31i.demorpc.codec.JSONDecoder;
import h31i.demorpc.codec.JSONEncoder;
import h31i.demorpc.transport.HTTPTransportServer;
import h31i.demorpc.transport.TransportServer;
import lombok.Data;

/**
 * server配置
 */
@Data
public class RpcServerConfig {

    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;

}
