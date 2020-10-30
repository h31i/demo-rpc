package h31i.demorpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONDecoderTest {

    @Test
    public void decode() {

        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setUid(100);
        bean.setName("h31i");
        bean.setAge(18);

        byte [] bytes = encoder.encode(bean);

        Decoder decoder = new JSONDecoder();
        TestBean bean1 = decoder.decode(bytes, TestBean.class);

        assertEquals(bean.getUid(), bean1.getUid());
        assertEquals(bean.getName(), bean1.getName());
        assertEquals(bean.getAge(), bean1.getAge());

    }
}