package org.tj.meta.base.study.thread.art;

/**
 * Created by 001 on 16/12/30.
 * 对于Synchronized关键字修饰静态方法，实例方法，代码块还是什么，另一个线程对这些代码的访问情况
 * 其实只要明白了对象锁和类锁就全都明白了。
 * 当一个线程获取了对象锁以后，所有尝试获取该对象的锁都是阻塞等待，普通方法不会受影响，因为他不需要获得锁就能执行，synchronized修饰的静态方法也不受影响，因为他只需要获得类锁就可以了。
 * 当获得的是类级别的锁时，其他尝试获取该类的类锁的都会被阻塞（就是synchronized修饰的静态方法）.
 */
public class ExSynchronized {

    Object object = new Object();

    public static void main(String[] args) {
        ExSynchronized exSynchronized = new ExSynchronized();
        ThreadA threadA = new ThreadA(exSynchronized);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(exSynchronized);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }

    public synchronized void  test1(){
        System.out.println(Thread.currentThread().getName()+" excuses synchronized test1");
        try {
            System.out.println(Thread.currentThread().getName()+" excuses synchronized test1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void  test2(){
        System.out.println(Thread.currentThread().getName()+" excuses synchronized test2");
    }

    public void test3(){
        System.out.println(Thread.currentThread().getName()+" excuses synchronized test3");
    }

    public static synchronized void test4(){
        System.out.println(Thread.currentThread().getName()+" excuses synchronized test4");
        try {
            System.out.println(Thread.currentThread().getName()+" excuses synchronized test4 and waiting 5 s");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void test5(){
        System.out.println(Thread.currentThread().getName()+" excuses synchronized test5");
    }

    public void test6(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+" excuses synchronized test6");
        }
    }

    public void test7(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+" excuses synchronized test7");
        }
    }

    public void test8(){
        synchronized(Runtime.getRuntime()){
            System.out.println(Thread.currentThread().getName()+" excuses synchronized test8");
        }
    }



}

class ThreadA extends Thread{
    ExSynchronized exSynchronized;
    public ThreadA(ExSynchronized exSynchronized){
        this.exSynchronized = exSynchronized;
    }
    @Override
    public void run() {
//        exSynchronized.test1();
        exSynchronized.test4();
    }
}

class ThreadB extends Thread{
    ExSynchronized exSynchronized;
    public ThreadB(ExSynchronized exSynchronized){
        this.exSynchronized = exSynchronized;
    }
    @Override
    public void run() {
        exSynchronized.test2();
//        exSynchronized.test3();
//        ExSynchronized.test4();
//        exSynchronized.test6();
//        exSynchronized.test7();
//        exSynchronized.test8();

    }
}
