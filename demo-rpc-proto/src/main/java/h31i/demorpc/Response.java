package h31i.demorpc;


import lombok.Data;

/**
 * 表示RPC的返回结果
 */
@Data
public class Response {

    /**
     * 服务返回编码：（0）-成功，（n）-失败
     */
    private int code;

    /**
     * 具体的错误信息
     */
    private String message = "OK";

    /**
     * 返回数据
     */
    private Object data;
}
