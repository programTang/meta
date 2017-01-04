package org.tj.meta.base.study.thread.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 001 on 17/1/4.
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印
 * 11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75.
 * 用condition解决
 */
public class TurnPrintCondition{

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    int count = 1;
    private int state = 1;

    class PrintThread implements Runnable{
        int name;

        public PrintThread(int name){
            this.name = name;
        }

        @Override
        public void run() {
            while (count<=75){
                lock.lock();
                if(name == state){
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName()+" : "+count++);
                    }
                    state = name%3 +1;
                }
                condition.signal();
                try {
                    condition.await();
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.lock();
            condition.signalAll();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TurnPrintCondition turnPrintCondition = new TurnPrintCondition();
        Thread thread1 = new Thread(turnPrintCondition.new PrintThread(1));
        thread1.setName("thread1");
        Thread thread2 = new Thread(turnPrintCondition.new PrintThread(2));
        thread2.setName("thread2");
        Thread thread3 = new Thread(turnPrintCondition.new PrintThread(3));
        thread3.setName("thread3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
