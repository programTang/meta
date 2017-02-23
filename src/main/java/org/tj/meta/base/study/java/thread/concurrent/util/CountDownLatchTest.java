package org.tj.meta.base.study.java.thread.concurrent.util;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 001 on 17/2/19.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI +" 已经到了");
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("人到齐，发车！");
    }
}
