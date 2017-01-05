package org.tj.meta.base.study.java.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 001 on 16/12/22.
 */
public class TestFileChannel {

    public static void readFile1(File file) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(file,"r");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
//初始化 capacity=48 limit = 48, position = 0;
        int bytesRead = channel.read(buf);
//buffer写模式，postion为写入的byte个数，最大为47.
        while (bytesRead != -1){
            buf.flip();
//切换成读模式，limit = position,表示读的时候最多可以读写入的数量,position = 0,从0开始读;
            byte[] bytes = new byte[48];
            int i=0;
            while (buf.hasRemaining()){
                bytes[i++] = buf.get();
//读出一个字节，同时position += 1;
            }
            System.out.print(new String(bytes,"UTF-8"));

            buf.clear();
//position = 0，limit = capacity.
            bytesRead = channel.read(buf);
        }
        channel.close();
    }

    public static void readFile2(File file) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile(file,"r");
        FileChannel channel = accessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        StringBuilder sb = new StringBuilder();
//初始化 capacity=48 limit = 48, position = 0;
        int bytesRead = channel.read(buf);
//buffer写模式，postion为写入的byte个数，最大为47.
        while (bytesRead != -1){
            buf.flip();
//切换成读模式，limit = position,表示读的时候最多可以读写入的数量,position = 0,从0开始读;
            while (buf.hasRemaining()){
                sb.append(buf.getChar());
//读出一个字节，同时position += 1;
            }
//            System.out.print(new String(bytes,"UTF-8"));
            buf.clear();
//position = 0，limit = capacity.
            bytesRead = channel.read(buf);
        }
        System.out.println(sb);
        channel.close();
    }

    public static void test() throws IOException {
//        RandomAccessFile accessFile = new RandomAccessFile("")

        File file = new File("src/main/resources/a.txt");
        System.out.println(file.getAbsolutePath());
        readFile1(file);
//        if (!file.exists()){
//            file.createNewFile();
//        }

    }

}
