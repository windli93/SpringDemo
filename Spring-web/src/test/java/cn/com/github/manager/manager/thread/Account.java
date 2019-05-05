package cn.com.github.test1.manager.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Account {
    private String name; // 开户名
    private double asset = 10.0; // 银行资产
    // 读写分离
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    public Account(String name, double asset) {
        this.name = name;
        this.asset = asset;
    }
    // 进行存款处理
    public boolean saveMoney(double money) {
        this.rwLock.writeLock().lock(); // 对写入数据进行锁定处理
        try {
            System.out.println("【（"
                    + Thread.currentThread().getName()
                    + "）存款-BEFORE】存款金额：" + money);
            TimeUnit.SECONDS.sleep(1);
            if (money > 0.0) { // 如果要存款肯定是要有钱
                this.asset += money;
                return true; // 存款成功
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("【（"
                    + Thread.currentThread().getName()
                    + "）存款-AFTER】总金额：" + this.asset);
            this.rwLock.writeLock().unlock(); // 进行解锁处理
        }
        return false;
    }

    public String getName() {  return this.name; }

    public double loadMoney() { // 返回当前的资金
        try {
            this.rwLock.readLock().lock();
            return this.asset;
        } finally { this.rwLock.readLock().unlock();  }
    }
}
