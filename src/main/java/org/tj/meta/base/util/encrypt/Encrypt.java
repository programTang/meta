package org.tj.meta.base.util.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 001 on 16/12/28.
 */
public class Encrypt {

    static char[] digits = {
            '0' , '1' , '2' , '3' ,
            '4' , '5' , '6' , '7' ,
            '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f'
    };

    public static byte[] md5(String source){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(source.getBytes());
            return bytes;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String md5Str(String source){
        return hex(md5(source));
    }


    public static String hex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for (int i=0,j=bytes.length;i<j;i++){
//            一个字节八位 先取高四位转成16进制 再取低四位转成16进制
//            取高四位 就是往右移4位 高四位都是1  低四位是高四位，这个时候 再跟 0000 1111做 & 运算。  取低四位，可以跟0000 1111 做 & 运算.
            int high = (bytes[i] >>> 4)&15;
            int low = bytes[i] & 15;
            builder.append(digits[high]);
            builder.append(digits[low]);
        }
        return builder.toString();
    }


}
