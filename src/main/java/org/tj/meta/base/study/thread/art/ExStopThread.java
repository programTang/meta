package org.tj.meta.base.study.thread.art;

/**
 * Created by 001 on 16/12/30.停止一个线程
 * 1. stop() 不推荐使用 强制停止一个线程
 *
 * 2. stopThread(); 手动写停止线程函数，有局限性，当线程在 阻塞 状态和sleep()是否无法停止，没有机会执行。
 *
 * 3. interrupt(); 并不会马上停止线程，他只是为线程加上了 中断标志，需要在安全的地方的手动判断 isInterrupt 为true 推出线程。
 * sleep()的时候如果被中断，就会抛出 InterruptedException 异常，我们可以在 catch 块中处理被中断的情况，这个时候如果想要真的中断线程，退出方法，
 * 要先调用 interrupt 方法设置中断标志，因为sleep 抛出异常时会清除中断标志,防止下次进入循环因为没有中断标志而继续执行。
 *
 * 4. isInterrupt 检查当前线程的中断标志
 *
 * 5. Thread.Interrupted()  静态方法，判断当前线程的中断状态，同时也清除当前线程的中断状态,在testInterrupted（）方法中，
 * 只会打印一次true，表示当前线程有中断标志，以后打印出来的都是 false.
 */
public class ExStopThread{

    boolean stopSignal = false;

    public void stopThread(){
        this.stopSignal = true;
    }

//    线程会在第五秒的时候推出方法
    public synchronized void stopBySignal(){
        int count = 0;
        long start = System.currentTimeMillis();
        while (true){
            while (System.currentTimeMillis() - start >1000){
                start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" is still running "+count);
                count++;
            }
            if(count == 5 && stopSignal == true){
                break;
            }
        }
    }
//在第五秒的时候线程休眠或阻塞 并不会退出方法
    public synchronized void stopBySignal2(){
        int count = 0;
        long start = System.currentTimeMillis();
        while (true){
            while (System.currentTimeMillis() - start >1000){
                start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" is still running "+count);
                count++;
            }
            if(count == 5 && stopSignal == true){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

//    改进上述方法  在第五秒的时候  即使sleep 也能被中断
    public synchronized void testInterrupt(){
        int count = 0;
        long start = System.currentTimeMillis();
        while (true){
            while (System.currentTimeMillis() - start >1000){
                start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" is still running "+count);
                count++;
            }
            if(count == 5 && Thread.currentThread().isInterrupted()){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                    break;
                }
                break;
            }
        }
    }

    //    interrupt 并不会推出线程，他只是为线程加上了 中断标志，需要在安全的地方的手动判断 isInterrupt 为true 推出线程。
    public synchronized void testInterrupt2(){
        int count = 0;
        long start = System.currentTimeMillis();
        while (true){
            while (System.currentTimeMillis() - start >1000){
                start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" is still running "+count);
                count++;
            }
        }
    }

    public synchronized void testInterrupted(){
        int count = 0;
        long start = System.currentTimeMillis();
        while (true){
            while (System.currentTimeMillis() - start >1000){
                System.out.println(Thread.interrupted());
                start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" is still running "+count);
                count++;
            }
            if(count == 5 && Thread.interrupted()){
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                    break;
                }
                break;
            }
        }
    }


    public static void main(String[] args) {
        ExStopThread exStopThread = new ExStopThread();
        Thread threadA = new Thread(()->{
//            exStopThread.stopBySignal();
//            exStopThread.testInterrupt();
//            exStopThread.testInterrupt2();
            exStopThread.testInterrupted();
        });
        threadA.setName("A");
        threadA.start();
//        再第五秒的时候停止线程
//        exStopThread.stopThread();
        threadA.interrupt();
//        Thread.interrupted();
    }


}
