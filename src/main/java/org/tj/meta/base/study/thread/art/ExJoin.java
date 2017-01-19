package org.tj.meta.base.study.thread.art;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/12/31 0031.
 * 通过join让 abcd 4个线程 按顺序执行
 */
public class ExJoin extends Thread {

    Thread thread;

    public ExJoin(){
        ReentrantLock lock =  new ReentrantLock(true);
    }

    public ExJoin(Thread thread){
        this.thread  = thread;
    }

    @Override
    public void run() {
        try {
            if (thread != null){
                System.out.println(Thread.currentThread().getName()+"线程阻塞，等待 "+thread.getName());
                thread.join();
            }
            System.out.println(Thread.currentThread().getName()+"  is running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread threadA = new ExJoin();
        threadA.setName("A");
        Thread threadB = new ExJoin(threadA);
        threadB.setName("B");
        Thread threadC = new ExJoin(threadB);
        threadC.setName("C");
        Thread threadD =  new ExJoin(threadC);
        threadD.setName("D");


        threadC.start();
        threadD.start();
        threadA.start();
        threadB.start();
    }
}
