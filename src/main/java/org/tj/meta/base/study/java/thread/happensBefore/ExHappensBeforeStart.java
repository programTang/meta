package org.tj.meta.base.study.java.thread.happensBefore;

/**
 * 如果A线程调用B线程的start()方法，也就是说 A线程启动B线程
 * 那么 A 调用 start 方法前的操作对 B  线程是可见的
 */
public class ExHappensBeforeStart {

    private static int var = 55;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread threadB = new Thread(() -> {
                System.out.println("B线程："+ var);
                var = 55;
            });
            var = 65;
            //调用 start() 前的操作对B线程是可见的，也就是说 B 线程内 var 是65；
            threadB.start();
            System.out.println("A线程join前："+ var);
            threadB.join();
            System.out.println("A线程join后："+ var);
            System.out.println("-----------");
        }

    }
}
