package org.tj.meta.base.study.java.thread.art;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ExWaitNotifyTransfer {

    public static void main(String[] args) throws InterruptedException {
    Account src = new Account(10000);
    Account target = new Account(10000);
    CountDownLatch countDownLatch = new CountDownLatch(9999);

    for (int i = 0; i < 9999; i++) {
        new Thread(()->{
            src.transactionToTarget(1,target);
            countDownLatch.countDown();
        }).start();
    }
    countDownLatch.await();
    System.out.println("src="+src.getBanalce() );
    System.out.println("target="+target.getBanalce() );
}

static class Account{ //账户类
    public Account(Integer banalce) {
        this.banalce = banalce;
    }
    private Integer banalce;
    public void transactionToTarget(Integer money,Account target){//转账方法
        Allocator.getInstance().apply(this,target);
        this.banalce -= money;
        target.setBanalce(target.getBanalce()+money);
        Allocator.getInstance().release(this,target);
    }
    public Integer getBanalce() {
        return banalce;
    }
    public void setBanalce(Integer banalce) {
        this.banalce = banalce;
    }
}
static class Allocator { //单例锁类
    private Allocator(){}
    private List<Account> locks = new ArrayList<>();
    public synchronized void apply(Account src,Account tag){
        while (locks.contains(src)||locks.contains(tag)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        locks.add(src);
        locks.add(tag);
    }
    public synchronized void release(Account src,Account tag){
        locks.remove(src);
        locks.remove(tag);
        this.notifyAll();
    }
    public static Allocator getInstance(){
        return AllocatorSingle.install;
    }
    static class AllocatorSingle{
        public static Allocator install = new Allocator();
    }
}
}
