package h31i.demorpc.codec;


/**
 * 序列化
 */
public interface Encoder {
    byte[] encode(Object obj);
}
