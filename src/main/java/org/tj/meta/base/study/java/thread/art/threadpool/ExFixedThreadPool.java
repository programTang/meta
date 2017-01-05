package org.tj.meta.base.study.java.thread.art.threadpool;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 001 on 17/1/3.
 */
public class ExFixedThreadPool {

    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":Thread ID: "+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        System.out.println(Runtime.getRuntime().availableProcessors());
        //        ExecutorService es = Executors.newFixedThreadPool(5);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            es.submit(myTask);

//            es.execute();
        }
        es.shutdown();
    }
}
