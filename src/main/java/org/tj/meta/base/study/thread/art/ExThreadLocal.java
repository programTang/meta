package org.tj.meta.base.study.thread.art;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 001 on 17/1/3.
 */
public class ExThreadLocal {

    private static ThreadLocal<SimpleDateFormat>  tl = new ThreadLocal<SimpleDateFormat>();

    public static class ParseDate implements Runnable{
        int i;

        public ParseDate(int i){
            this.i = i;
        }

        @Override
        public void run() {
            try {
//                synchronized (sdf){
                if (tl.get() == null){
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                System.out.println(tl.get().parse("2017-01-03 17:51:"+i%60));
//                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ParseDate(i));
        }
//        for (int i = 0; i < 1000; i++) {
//            new Thread(new ParseDate(i)).start();
//        }
    }

}
