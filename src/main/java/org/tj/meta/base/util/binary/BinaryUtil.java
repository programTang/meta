package org.tj.meta.base.util.binary;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryUtil {


    /**
     * 数字转换成字节数组
     * 一个字节是8位，无符号的话取值范围是 [0,255], 有符号的话取值范围 [-128, 127].
     * 一个int4字节，可以转换成4长度的byte数组，每一个byte放8位，byte[0]放高八位，byte[3]放低八位
     * @param num
     * @return
     */
    public static byte[] int2byteArray(int num){
        byte[] bytes = new byte[4];
        //高八位的值 相当于右移 24 位
        bytes[0] = (byte) (num >> 24);
        //右移 16 位后，高八位需要变成0,低八位不变：高八位跟0做按位与，低八位都跟1做按位与：0x00FF;
        bytes[1] = (byte) ((num >> 16) & 0xFF);
        bytes[2] = (byte) ((num >> 8) & 0xFF);
        bytes[3] = (byte) (num & 0xFF);
        return bytes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(int2byteArray(0)));
        System.out.println(Arrays.toString(int2byteArray(111)));
        System.out.println(Arrays.toString(int2byteArray(127)));
        System.out.println(Arrays.toString(int2byteArray(128)));
        System.out.println(Arrays.toString(int2byteArray(-1)));
        System.out.println(Arrays.toString(int2byteArray(129)));

//        List<Integer> integers = Collections.synchro
    }
}
