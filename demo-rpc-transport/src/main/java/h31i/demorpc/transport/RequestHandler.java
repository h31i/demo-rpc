package h31i.demorpc.transport;


import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * 处理请求的handler
 */
public interface RequestHandler {
    void onRequest(InputStream recive, OutputStream toResponse);
}
