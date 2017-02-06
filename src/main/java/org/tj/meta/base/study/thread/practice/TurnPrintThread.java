package org.tj.meta.base.study.thread.practice;

/**
 * Created by Administrator on 2017/1/3 0003.
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10,
 * 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75
 */
public class TurnPrintThread {

        int count = 0;

        class Thread1 implements Runnable{

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+" : "+count++);
                }

            }
        }
}
