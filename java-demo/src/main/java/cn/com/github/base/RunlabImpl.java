package cn.com.github.base;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class RunlabImpl implements Runnable {

    public void run() {
        log.info("使用runnable接口实现。。。。。。。。");
    }

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            RunlabImpl impl = new RunlabImpl();
            Thread thread = new Thread(impl);
            thread.start();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}
