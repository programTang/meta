package org.tj.meta.base.study.thread.art.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 001 on 17/1/4.
 *
 */
public class ExThreadPool {

    public static void testThreadPool(ExecutorService executorService){
        for (int i = 1; i < 5; i++) {
            final int taskId = i;
            executorService.execute(() -> {
                for (int j = 0; j < 5; j++) {
                System.out.println("第 "+taskId+" 个任务第 "+j+" 次被 "+Thread.currentThread().getName()+" 执行");
//                System.out.println("第 "+taskId+" 个任务第  次被 "+Thread.currentThread().getName()+" 执行");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
//            executorService.
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        testThreadPool(executorService);
    }
}
