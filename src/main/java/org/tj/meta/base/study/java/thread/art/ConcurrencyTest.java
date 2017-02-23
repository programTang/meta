<<<<<<< HEAD
package org.tj.meta.base.study.java.thread.art;

import org.junit.Test;
import org.tj.meta.base.study.design.proxy.cglib.AlgorithmCglibProxy;

import java.util.HashMap;

/**
 * Created by 001 on 16/12/29.
 * 当累加操作越小的时候，尤其是1w 并行所花的时间几乎是串行的100倍，这是因为线程有创建和上下文切换的开销,而这些开销比累加计算开销大得多
 * 当累加操作越大的时候，并行与串行所执行的时间差距越来越小，并最终超越串行，这是因为随着计算量越来越大，线程切换的开销在计算开销面前已经
 * 没那么重要，多核的优势应该发挥出来。
 */
public class ConcurrencyTest {
    public static final long count = 10000000L;

    @Test
    public void testSpeed() throws InterruptedException {
        ConcurrencyTest test = (ConcurrencyTest) new AlgorithmCglibProxy().getProxy(ConcurrencyTest.class);
        test.concurrencyAdd();
        test.serialAdd();
//        Thread
    }

    public void concurrencyAdd() throws InterruptedException {
        Thread thread = new Thread(() -> {
            int a = 0;
            for (int i = 0; i < count; i++) {
                a += 5;
            }
        });
        thread.start();

        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
    }

    public void serialAdd(){
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
    }
}
=======
//package org.tj.meta.base.study.java.thread.art;
//
//import org.junit.Test;
//import org.tj.meta.base.study.design.proxy.cglib.AlgorithmCglibProxy;
//
///**
// * Created by 001 on 16/12/29.
// * 当累加操作越小的时候，尤其是1w 并行所花的时间几乎是串行的100倍，这是因为线程有创建和上下文切换的开销,而这些开销比累加计算开销大得多
// * 当累加操作越大的时候，并行与串行所执行的时间差距越来越小，并最终超越串行，这是因为随着计算量越来越大，线程切换的开销在计算开销面前已经
// * 没那么重要，多核的优势应该发挥出来。
// */
//public class ConcurrencyTest {
//    public static final long count = 10000000L;
//
//    @Test
//    public void testSpeed() throws InterruptedException {
//        ConcurrencyTest test = (ConcurrencyTest) new AlgorithmCglibProxy().getProxy(ConcurrencyTest.class);
//        test.concurrencyAdd();
//        test.serialAdd();
////        Thread
//    }
//
//    public void concurrencyAdd() throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            int a = 0;
//            for (int i = 0; i < count; i++) {
//                a += 5;
//            }
//        });
//        thread.start();
//
//        int b = 0;
//        for (int i = 0; i < count; i++) {
//            b--;
//        }
//        thread.join();
//    }
//
//    public void serialAdd(){
//        int a = 0;
//        for (int i = 0; i < count; i++) {
//            a += 5;
//        }
//        int b = 0;
//        for (int i = 0; i < count; i++) {
//            b--;
//        }
//    }
//}
>>>>>>> 03f2a9ea151aff7d7acd2a4a18a1ce227ab3b36c
