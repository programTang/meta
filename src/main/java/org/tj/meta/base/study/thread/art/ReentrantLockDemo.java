package org.tj.meta.base.study.thread.art;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 001 on 17/1/3.
 */
public class ReentrantLockDemo{

    public static ReentrantLock reentrantLock1 = new ReentrantLock();
    public static ReentrantLock reentrantLock2 = new ReentrantLock();


    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock1.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("线程1 被中断 释放 lock1");
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("线程1 等待获取 lock2 ");
                    reentrantLock2.lockInterruptibly();
                    System.out.println("线程1 获取到 lock2 ");
                } catch (InterruptedException e) {
                    System.out.println("线程1 被中断");
                    reentrantLock1.unlock();
                    System.out.println("线程1 释放锁");
                    e.printStackTrace();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                reentrantLock2.unlock();
//                System.out.println("线程2 释放 lock2");
                try {
                    System.out.println("线程2 等待获取 lock1");
                    reentrantLock1.lockInterruptibly();
                    System.out.println("线程2 获取到 lock1 ");
                    reentrantLock2.unlock();
                    reentrantLock1.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();

    }
}
