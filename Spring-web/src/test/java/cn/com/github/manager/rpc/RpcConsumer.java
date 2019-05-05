package cn.com.github.manager.rpc;

import cn.com.github.service.inter.HelloService;
import cn.com.github.service.manager.RpcFramework;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RpcConsumer
 * @AUTHOR ragrokli
 * @DATE 2019/5/5 14:42
 **/
@Slf4j
public class RpcConsumer {

    public static void main(String[] args) {
        try {
            HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 8009);
            for (int i = 0; i < 100; i++) {
                String hello = service.hello("World" + i);
                log.info("hello......!{}", hello);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
