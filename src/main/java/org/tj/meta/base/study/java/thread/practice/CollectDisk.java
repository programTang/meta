package org.tj.meta.base.study.java.thread.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by 001 on 17/2/19.
 * 三个线程先统计abc是三个磁盘，统计好了再交给另一个线程统计。
 */
public class CollectDisk {

    static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            int sum = 0;
            Set<String> disks = map.keySet();
            for (String disk:disks){
                sum = sum+map.get(disk);
            }
            System.out.println("总磁盘大小: "+sum);
        });

        new Thread(new DiskCounter("a",cyclicBarrier)).start();
        new Thread(new DiskCounter("b",cyclicBarrier)).start();
        new Thread(new DiskCounter("c",cyclicBarrier)).start();
    }

    static class DiskCounter implements Runnable{
        String name;
        int count;
        CyclicBarrier cyclicBarrier;

        public DiskCounter(String name,CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            count = new Random().nextInt(10);
            System.out.println(name+"号磁盘的大小为"+count);
            map.put(name,count);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name+" 结束");
        }
    }
}
