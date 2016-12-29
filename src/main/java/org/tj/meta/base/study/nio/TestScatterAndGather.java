package org.tj.meta.base.study.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by 001 on 16/12/23.
 */
public class TestScatterAndGather {

    public static void copyFile(File from,File to) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile(from,"r");
        RandomAccessFile toFile = new RandomAccessFile(to,"rw");
        FileChannel fromChannel  = fromFile.getChannel();
        FileChannel toChannel = toFile.getChannel();
        System.out.println(fromChannel.size());
        toChannel.transferFrom(fromChannel, 0, fromChannel.size());
        toChannel.close();
//        fromFile.getChannel().transferFrom(to)
    }

    public static void test(String[] args) throws IOException {
        File from = new File("src/main/resources/a.txt");
        File to = new File("src/main/resources/b.txt");

        copyFile(from,to);
    }
}
