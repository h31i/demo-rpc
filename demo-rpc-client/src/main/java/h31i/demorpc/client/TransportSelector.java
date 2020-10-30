package h31i.demorpc.client;


import h31i.demorpc.Peer;
import h31i.demorpc.transport.TransportClient;

import java.util.List;

/**
 *
 * 表示选择哪个server去连接
 *
 */
public interface TransportSelector {

    /**
     * 初始化selector
     *
     * @param peers 可以连接的server端点信息
     * @param count client与server建立多少个链接
     * @param clazz client实现class
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);

    /**
     * 选择一个transport与server做交互
     *
     * @return  网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     *
     * @param client
     */
    void release(TransportClient client);

    void close();
}
