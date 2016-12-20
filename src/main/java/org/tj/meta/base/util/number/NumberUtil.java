package org.tj.meta.base.util.number;

import org.tj.meta.base.util.string.StringUtil;

import java.util.Arrays;

/**
 * Created by 001 on 16/12/15.
 */
public class NumberUtil {

    final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9' , 'a' , 'b' ,
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
        'o' , 'p' , 'q' , 'r' , 's' , 't' ,
        'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public static String radixString(int i,int radix){
        if (radix < 2 || radix > 31)
            radix = 10;
        boolean negative = (i < 0);
        if (negative)
            i = -i;
        char []str = new char[33];
        int pos = 32;
        while (i >= radix){
            str[pos--] = digits[i%radix];
            i /= radix;
        }
        str[pos] = digits[i];
        if (negative)
            str[--pos]='-';
        return new String(str,pos,(33-pos));
//        return sb.toString();
    }

    public static String toUnsignedString(int i){
        if (i>=0)
            return radixString(i,10);
        return "";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(radixString(-100,2));
        System.out.println(Integer.toString(-5,2));
        System.out.println(Integer.toUnsignedString(-1,2));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }

}
