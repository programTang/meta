package org.tj.meta.base.study.java.thread.happensBefore;

/**
 * 这条是关于线程等待的。它是指主线程 A 等待子线程 B 完成（主线程 A 通过调用子线程 B 的 join() 方法实现），
 * 当子线程 B 完成后（主线程 A 中 join() 方法返回），主线程能够看到子线程的操作。当然所谓的“看到”，指的是对共享变量的操作。
 * 换句话说就是，如果在线程 A 中，调用线程 B 的 join() 并成功返回，
 * 那么线程 B 中的任意操作 Happens-Before 于该 join() 操作的返回。具体可参考下面示例代码。
 */
public class ExHappensBeforeJoin {

    public static int var = 66;

    public static void main(String[] args) throws InterruptedException {

        Thread threadB = new Thread(() -> {
            var = 55;
        });

        threadB.start();
        //没有 Happens-Before 规则保障，结果不一定。
        System.out.println("join前："+ var);
        threadB.join();
        //线程 B 的操作 Happens-Before 于该 join 返回后的操作。
        System.out.println("join后："+ var);
    }
}
