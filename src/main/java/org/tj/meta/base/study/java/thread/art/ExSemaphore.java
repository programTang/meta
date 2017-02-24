package org.tj.meta.base.study.java.thread.art;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 001 on 17/1/3.
 */
public class ExSemaphore implements Runnable {
    final Semaphore semaphore = new Semaphore(5);
    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId()+" is done");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final ExSemaphore demo = new ExSemaphore();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }
        System.out.println((System.currentTimeMillis() - start)/1000);
    }
}
