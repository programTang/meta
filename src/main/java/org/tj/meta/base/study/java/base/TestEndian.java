package org.tj.meta.base.study.java.base;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by 001 on 17/1/18.
 * 判断JVM是采用大端还是小段字节序
 */
public class TestEndian {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[4];
        bytes[0] = 0x12;
        bytes[1] = 0x34;
        bytes[2] = 0x56;
        bytes[3] = 0x78;
        System.out.println(new String(bytes));
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        System.out.println(Integer.toHexString(dis.readInt()));
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.put(bytes[0]);
    }
}
