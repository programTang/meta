package org.tj.meta.base.study.java.thread.art;

public class ExInterrupt {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                Thread.yield();
            }
        });
        thread.start();
        thread.interrupt();
    }

}
