package h31i.demorpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONEncoderTest {

    @Test
    public void encode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setUid(100);
        bean.setName("h31i");
        bean.setAge(18);

        byte [] bytes = encoder.encode(bean);

//        System.out.println(bytes);
        assertNotNull(bytes);
    }
}