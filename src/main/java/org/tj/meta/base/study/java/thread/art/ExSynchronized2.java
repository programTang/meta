package org.tj.meta.base.study.java.thread.art;

public class ExSynchronized2 {

    long value = 0L;

    long getNoSynchronized() {
        return value;
    }

    synchronized long getNoWithSynchronized() {
        return value;
    }

    void addOneNoSynchronized() {
        value += 1;
    }

    synchronized void addOneWithSynchronized() {
        value += 1;
    }

    public static void main(String[] args) throws InterruptedException {
        ExSynchronized2 exSynchronized2 = new ExSynchronized2();
//        for (int k = 0; k < 1000; k++) {
//            for (int i = 0; i < 1000; i++) {
//                Thread thread = new Thread(() -> {
//                    exSynchronized2.addOneNoSynchronized();
//                });
//                thread.start();
//            }
//            System.out.println(exSynchronized2.getNoSynchronized());
//            exSynchronized2.value = 0;
//            System.out.println(exSynchronized2.getNoSynchronized());
//
//        }

        for (int k = 0; k < 1000; k++) {
            for (int i = 0; i < 1000; i++) {
                Thread thread = new Thread(() -> {
                    exSynchronized2.addOneNoSynchronized();
                });
                thread.start();
                thread.join();
            }
            System.out.println(exSynchronized2.getNoWithSynchronized());
            exSynchronized2.value = 0;
            System.out.println(exSynchronized2.getNoSynchronized());

        }


    }

}
