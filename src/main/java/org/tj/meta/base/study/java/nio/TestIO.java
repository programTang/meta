package org.tj.meta.base.study.java.nio;

import java.io.*;

/**
 * Created by 001 on 17/2/7.
 */
public class TestIO {

    static void bufferReader() throws IOException {
        Reader reader = new InputStreamReader(System.in,"UTF-8");
//        BufferedReader reader1 = new BufferedReader(new FileReader(new File("")));
//        int text = reader.read();
        char[] buff = new char[1024];
        int length = reader.read(buff);
//        System.out.println(reader.read(buff));
        System.out.println(new String(buff,0,length));
//        System.out.println((char)text);
    }

    public static void main(String[] args) throws IOException {
        bufferReader();
    }
}
