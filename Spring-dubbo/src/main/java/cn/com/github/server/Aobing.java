package cn.com.github.server;

import java.util.*;

public interface Aobing {

    void say();
}

class Main {
    public static void main(String[] args) {
        ServiceLoader<Aobing> serviceLoader = ServiceLoader.load(Aobing.class);
        Iterator<Aobing> iterable = serviceLoader.iterator();
        while (iterable.hasNext()) {
            Aobing aobing = iterable.next();
            aobing.say();
        }
    }
}