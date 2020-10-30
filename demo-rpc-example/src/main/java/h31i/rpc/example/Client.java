package h31i.rpc.example;

import h31i.demorpc.client.RpcClient;

public class Client {

    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int r1 = service.add(1,2);
        int r2 = service.minus(7, 4);
        System.out.println(r1);
        System.out.println(r2);

    }
}
