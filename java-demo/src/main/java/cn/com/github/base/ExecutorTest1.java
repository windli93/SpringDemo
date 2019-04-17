package cn.com.github.base;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class ExecutorTest1 {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dateStr = format.format(currentTime);
        return dateStr;
    }

    public void run() throws Exception{
        Callable myCall = new Callable() {
            public Object call() throws Exception {
                Thread.sleep(3000);
                log.info("call方法执行了");
                return "run calling";
            }
        };
        System.out.println("提交任务之前 " + getStringDate());
        Future future = executor.submit(myCall);
        System.out.println("提交任务之后，获取结果之前 " + getStringDate());
        System.out.println("获取返回值: " + future.get());
        System.out.println("获取到结果之后 " + getStringDate());
    }


    public static void main(String args[]) throws Exception{
         ExecutorTest1 test1 = new ExecutorTest1();
         test1.run();
    }

}
