package org.tj.meta.base.study.thread.practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 001 on 17/1/4.
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印
 * 11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75.
 */
public class TurnPrintThread{

    int count = 1;
    AtomicInteger state = new AtomicInteger(1);

    class PrintThread implements Runnable{

        int nama;

        public PrintThread(int name){
            this.nama = name;
        }

        @Override
        public void run() {
           while (count<=75){
               synchronized (state){
                   if (nama == state.get()){
                       for (int i = 0; i < 5; i++) {
                           System.out.println(Thread.currentThread().getName()+" : "+count++);
                       }
                       state.set(nama%3 + 1);
                   }
                   state.notify();
                   try {
                       state.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
           synchronized (state){
//               最后唤醒thread3,因为thread3还在阻塞。
               state.notifyAll();
           }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        TurnPrintThread thread = new TurnPrintThread();
        Thread thread1 = new Thread(thread.new PrintThread(1));
        thread1.setName("thread1");
        Thread thread2 = new Thread(thread.new PrintThread(2));
        thread2.setName("thread2");
        Thread thread3 = new Thread(thread.new PrintThread(3));
        thread3.setName("thread3");

        thread1.start();
//        Thread.sleep(1000);
        thread2.start();
//        Thread.sleep(1000);
        thread3.start();

//        thread.state.notifyAll();
    }

}
