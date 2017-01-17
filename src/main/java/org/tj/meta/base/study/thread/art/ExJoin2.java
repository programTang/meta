package org.tj.meta.base.study.thread.art;

/**
 * Created by Administrator on 2016/12/31 0031.
 */
public class ExJoin2 extends Thread {

    String name;

    public ExJoin2(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+"is running ");
    }

    public static void main(String[] args) throws InterruptedException {
        ExJoin2 threadA = new ExJoin2("A");
        ExJoin2 threadB = new ExJoin2("B");
        ExJoin2 threadC = new ExJoin2("C");
        ExJoin2 threadD = new ExJoin2("D");

        threadA.start();
        threadA.join();

        threadB.start();
        threadB.join();

        threadC.start();
        threadC.join();

        threadD.start();
        threadD.join();
    }
}
