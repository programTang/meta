package org.tj.meta.base.study.java.thread.practice;

/**
 * Created by 001 on 17/1/4.
 * 子线程循环10次，主线程循环20次，如此循环5次，
 */
public class MainSubThread {

    private String name = "Sub";
    int count = 0;

    class LoopThread implements Runnable{

//
//        public LoopThread(String name){
//            this.name = name;
//        }

        @Override
        public void run() {
            while (count <= 100){
                synchronized (this){
                    if (name.equals(Thread.currentThread().getName())){
                        if (Thread.currentThread().getName().equals("Main")){
                            for (int i = 0; i < 20; i++) {
                                System.out.println(Thread.currentThread().getName()+" : " +i);
                            }
                            System.out.println("第"+count++ +"次大循环 ");
                            name = "Sub";
                        }else {
                            for (int i = 0; i < 10; i++) {
                                System.out.println(Thread.currentThread().getName()+" : " +i);
                            }
                            name = "Main";
                        }
                    }
                    this.notify();
                    try {
//                        System.out.println(Thread.currentThread().getName());
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (this){
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        MainSubThread mainSubThread = new MainSubThread();
        LoopThread loopThread = mainSubThread.new LoopThread();
        Thread threadMain = new Thread(loopThread);
        threadMain.setName("Main");
        Thread threadSub = new Thread(loopThread);
        threadSub.setName("Sub");
        threadMain.start();
        threadSub.start();
    }
}
