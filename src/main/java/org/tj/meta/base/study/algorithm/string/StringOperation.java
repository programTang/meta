package org.tj.meta.base.study.algorithm.string;

/**
 * Created by 001 on 17/1/23.
 * 对字符串的处理算法
 */
public class StringOperation {

    /**
     *
     * @param str
     * @return
     */
    public static int string2Int(String str){
//        Assert.notNull(str);
        int sum = 0;
        int position = str.length();
        boolean isNegative = false;
        if (str.startsWith("-")){
            isNegative = true;
            if (position > 11){
                throw new IllegalArgumentException("number too smaller than the min int "+Integer.MIN_VALUE);
            }
            --position;
        }else {
            if (position > 10){
                throw new IllegalArgumentException("number too bigger than the max int "+Integer.MAX_VALUE);
            }
        }
        for(;position>0;){
            int value = str.charAt(--position);
            if (value >= 48 && value <= 57){
                value = value-48;
                System.out.println(sum +"  "+value);
                sum += value*Math.pow(10,position);
            }else {
                throw new IllegalArgumentException((char) value+" not a legal number in string");
            }
        }
        return isNegative?-sum:sum;
    }


    public static void main(String[] args) {
//        int a = 'a';
//        int b = '0';
//        int c = '9';
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(Integer.MAX_VALUE);

//        System.out.println(string2Int((Integer.MAX_VALUE+1)+""));
//        int a = 2147483640;
//        int b = 8;
//        a+=b;
//        很奇怪 一个会溢出   一个变成了最大值
//        a += b*Math.pow(10,0);
//        a += b*Math.pow(10,0);
//        System.out.println(a);
//        System.out.println(string2Int("-2147483647"));
        System.out.println(string2Int("7483647"));
    }
}
