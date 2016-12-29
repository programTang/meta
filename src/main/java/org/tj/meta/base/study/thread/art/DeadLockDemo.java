package org.tj.meta.base.study.thread.art;

/**
 * Created by 001 on 16/12/29.
 * 死锁 当两个线程 互相都在等待另一个线程释放锁，会无限循环等待。
 * 用 jstack 查看，发现AB 两个线程都是 BLOCK 状态，且分别阻塞在获取锁的那一行。
 */
public class DeadLockDemo {

    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args){
        Thread A = new Thread(() -> {
            synchronized(a){
                try {
                    System.out.println("A get a's lock");
//                    让A线程休眠2秒 使B线程执行
                    Thread.sleep(2000);
//                    去拿b的锁
                    System.out.println("A is waiting for b'lock");
                    synchronized (b){
                        System.out.println("A is finished");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("B got b's lock");
                    try {
                        Thread.sleep(2000);
//                        去拿a的锁
                        System.out.println("B is waiting for a'lock");
                        synchronized (a){
                            System.out.println("B is finished");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        A.start();
        B.start();

    }
}
