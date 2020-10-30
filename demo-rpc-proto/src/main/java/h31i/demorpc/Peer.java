package h31i.demorpc;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表示网络传输中的一个端点
 */
@Data
@AllArgsConstructor
public class Peer {

    private String host;
    private int port;
}
