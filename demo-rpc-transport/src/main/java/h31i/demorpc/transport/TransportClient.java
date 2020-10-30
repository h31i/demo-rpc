package h31i.demorpc.transport;


import h31i.demorpc.Peer;

import java.io.InputStream;

/**
 * 1、创建连接
 * 2、发送数据，并且等待响应
 * 3、关闭连接
 */
public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data);
    void close();
}
