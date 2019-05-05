package cn.com.github.manager.rpc;

import cn.com.github.service.impl.HelloServiceImpl;
import cn.com.github.service.inter.HelloService;
import cn.com.github.service.manager.RpcFramework;

/**
 * @ClassName RpcProvider
 * @AUTHOR ragrokli
 * @DATE 2019/5/5 14:41
 **/
public class RpcProvider {

    public static void main(String[] args) {
        HelloService service = new HelloServiceImpl();
        try {
            RpcFramework.export(service, 8009);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
