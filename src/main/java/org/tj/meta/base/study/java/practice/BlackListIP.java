package org.tj.meta.base.study.java.practice;

import java.io.*;

/**
 * Created by 001 on 17/2/23.
 * 有大量黑名单ip，给你一个ip，找出是否在黑名单内
 * 只需要2的32次方大小就可以表示所有ip  规则是可以把ip看做256进制的数。
 */
public class BlackListIP {

    static final int MAX_IPS = 1<<31;

    public static void main(String[] args) {
        long a = 1 << 32;
//        boolean[] ips = new boolean[MAX_IPS];

        System.out.println(a);
    }

    public static void generateBlackIps(int num) throws IOException {
        Writer writer = new FileWriter(new File("./black_ip.txt"));
        BufferedWriter bw = new BufferedWriter(writer);
    }

}
