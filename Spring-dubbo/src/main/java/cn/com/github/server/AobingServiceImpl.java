package cn.com.github.server;

/**
 * @AUTHOR windli
 * @DATE 2021/7/22 17:50
 * @DESC
 **/

public class AobingServiceImpl implements AobingService{
    @Override
    public String hello(String name) {
        return "Yo man Hello，I am" + name;
    }
}
