package org.tj.meta.base.study.java.thread.art.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by 001 on 17/1/3.
 */
public class ExScheduleExecutorDemo implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis()/1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
//        System.out.println(System.currentTimeMillis()/1000);
        ses.scheduleAtFixedRate(new ExScheduleExecutorDemo(),0,2, TimeUnit.SECONDS);
    }
}
