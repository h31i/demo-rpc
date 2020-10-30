package h31i.demorpc.server;

import h31i.demorpc.Request;
import h31i.demorpc.common.utils.ReflectionUtils;

public class ServiceInvoker {

    public Object invoke(ServiceInstance service, Request request){
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getParameters()
        );
    }
}
