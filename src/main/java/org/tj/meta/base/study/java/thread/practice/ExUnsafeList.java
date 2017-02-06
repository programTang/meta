package org.tj.meta.base.study.java.thread.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 001 on 17/1/16.
 */
public class ExUnsafeList {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Thread[] threads = new Thread[1000];

        for (int i = 0,j = threads.length; i < j; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                try {
                    Thread.currentThread().sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(finalI);
            });
        }
        for (int i = 0,j = threads.length; i < j; i++) {
            threads[i].start();
        }
        Thread.currentThread().sleep(10000);
        System.out.println(list.size());
        System.out.println(list);
    }
}
