package h31i.demorpc.transport;


/**
 * 1 启动监听
 * 2 接受请求
 * 3 关闭监听
 */
public interface TransportServer {
    void init(int port , RequestHandler handler);
    void start();
    void stop();
}
