package org.tj.meta.base.study.java.thread.art;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 001 on 17/1/3.
 */
public class ExCondition extends Thread {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("condition 当前线程等待，并且释放锁");
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("被唤醒");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread thread = new ExCondition();
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        System.out.println("获取锁");
        condition.signal();
//        如果不unlock  那么永远也不会释放锁，await 线程永远也没机会执行。
        lock.unlock();
    }
}
