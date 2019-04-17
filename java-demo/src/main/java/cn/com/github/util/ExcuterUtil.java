package cn.com.github.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcuterUtil {

    private static int size = 100;

    ExecutorService pool = Executors.newFixedThreadPool(size);

    synchronized

    public static void hadlerTask() {
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < size; i++) {
            Callable c = new Callable() {
                public Object call() throws Exception {
                    return null;
                }
            };
        }
    }
}
