package org.tj.meta.base.study.java.thread.concurrent.atomic;

/**
 * Created by 001 on 17/2/19.
 */
public class AtomicRefrenceTest {

    int i = 0;

   void add(){
       i++;
   }

   int get(){
       return i;
   }

    public static void main(String[] args) throws InterruptedException {
        AtomicRefrenceTest test = new AtomicRefrenceTest();
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.add();
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        Thread.sleep(3000);
        System.out.println(test.get());
    }


}
