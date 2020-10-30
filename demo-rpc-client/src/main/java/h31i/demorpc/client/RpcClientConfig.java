package h31i.demorpc.client;

import h31i.demorpc.Peer;
import h31i.demorpc.codec.Decoder;
import h31i.demorpc.codec.Encoder;
import h31i.demorpc.codec.JSONDecoder;
import h31i.demorpc.codec.JSONEncoder;
import h31i.demorpc.transport.HTTPTransportClient;
import h31i.demorpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 */
@Data
public class RpcClientConfig {

    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1", 3000)
    );
}
