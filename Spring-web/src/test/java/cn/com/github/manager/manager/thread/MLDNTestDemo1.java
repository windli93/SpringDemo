package cn.com.github.test1.manager.thread;

public class MLDNTestDemo1 {
    public static void main(String[] args) throws Exception {
        Account account = new Account("小林子", 15.0);
        double money[] = new double[]{5.0, 300.0, 5000.0, 50000.0, 1000.0};
        for (int x = 0; x < 2; x++) { // 设置两个写线程
            new Thread(() -> {
                for (int y = 0; y < money.length; y++) {
                    account.saveMoney(money[y]);
                }
            }, "存款用户-" + x).start();
        }
        for (int x = 0; x < 10; x++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()
                        + "、查账，账户名：" + account.getName() + "、资产总额："
                        + account.loadMoney());
            }, "收款人-" + x).start();
        }
    }
}
