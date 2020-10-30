package h31i.demorpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ReflectionUtilsTest {


    /**
     *
     * 测试根据class获取对象
     *
     */

    @Test
    public void newInstance() {

        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }


    /**
     *
     * 测试获取公共方法
     *
     */
    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1, methods.length);

        String mname = methods[0].getName();
        assertEquals("b", mname);
    }

    /**
     *
     * 测试调用指定对象指定方法
     *
     */
    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];
        TestClass t = new TestClass();
        Object r= ReflectionUtils.invoke(t, b);

        assertEquals("b", r);

    }
}