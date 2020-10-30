package h31i.demorpc.server;


import h31i.demorpc.Request;
import h31i.demorpc.ServiceDescriptor;
import h31i.demorpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理RPC暴露的服务
 */
@Slf4j
public class ServiceManager {

    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register( Class<T> interfaceClass, T bean){
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for ( Method method: methods){
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);

            services.put(sdp, sis);
            log.info("register servive: {} {}", sdp.getClazz() ,sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }

}
