package cn.com.github.base;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThredTest1 extends Thread {


    public void test() {
        for (int i = 0; i < 100; i++) {
             log.info("目前的i值{}",i);
        }
    }


    public void run() {
        test();
    }

    public static void main(String[] args) {
        ThredTest1 thred1 = new ThredTest1();
        thred1.start();
    }

}
