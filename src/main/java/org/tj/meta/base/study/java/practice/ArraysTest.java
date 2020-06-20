package org.tj.meta.base.study.java.practice;


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.将两个有序数组合并成一个有序数组
 *  public int[] merge(int[] a, int[] b) { }  
 *
 *  2.有序大数组，查找一个值在这个有序数组中第一次出现的位置
 * ，如： [1, 2, 3, 3, 4, 4, 4, 5, ..., n]􏰐，4第一次出现的位置是：􏰷􏰶
 * 4 
 * public int index(int[] a, int key) { }
 */
public class ArraysTest {

    public int[] merge(int[] a, int[] b) {
        if (a != null && b == null){
            return a;
        }else if (a == null && b != null){
            return b;
        }else if (a == null && b == null){
            return null;
        }

        int indexA = 0;
        int indexB = 0;
        int[] c = new int[a.length + b.length];
        int indexC = 0;

        while (indexA < a.length && indexB < b.length){
            if (a[indexA] <= b[indexB]){
                c[indexC++] = a[indexA++];
            } else {
                c[indexC++] = b[indexB++];
            }
        }

        if (indexA <= a.length){
            for (;indexA < a.length;){
                c[indexC++] = a[indexA++];
            }
        }

        if (indexB <= b.length){
            for (;indexB < b.length;){
                c[indexC++] = b[indexB++];
            }
        }
        return c;
    }

    /**
     * .有序大数组，查找一个值在这个有序数组中第一次出现的位置
     *  * ，如： [1, 2, 3, 3, 4, 4, 4, 5, ..., n]􏰐，4第一次出现的位置是：􏰷􏰶
     * @param a
     * @param key
     * @return
     */
    public int index(int[] a, int key) {
        if (a == null) return -1;
        return binarySearch(a, key, 0, a.length-1);

    }

    public int binarySearch(int[] a, int key, int left, int right){
        if (left == right){
            if (a[left] == key){
                return left;
            }
            return -1;
        }
        int mid = (left + right)/2;
        if (a[mid] < key){
            return binarySearch(a, key, mid+1, right);
        }else if (a[mid] > key){
            return binarySearch(a, key, left, mid-1);
        }
        if (mid == 0 || a[mid-1] < key){
            return mid;
        }
        return binarySearch(a, key, left, mid-1);
    }

//    public static void main(String[] args) {
//        int[] a = {1, 4, 6, 6, 8, 9, 10};
//        int[] b = {2, 3, 5, 9, 9 ,11};
//        int[] c = new ArraysTest().merge(a, b);
//        System.out.print("数组c:");
//        for (int i = 0; i < c.length; i++) {
//            System.out.print(c[i] +" ");
//        }
//        System.out.println("");
//        System.out.println("11的位置："+ new ArraysTest().index(c, 10));
//    }



//    int getRoot(int[] list){
//
//        int length = list.length;
//
//
//    }
//
//    int getRoot(int[] n){
//        if(n.length == 2){
//            return hash(n[0], n[1]);
//        }else if (n.length == 1){
//            return hash(n[0], 0);
//        }
//
//        int[] lastRoof = new int[(int) Math.ceil(n.length/2)];
//        int index = 0;
//        for (int i = 0; i < n.length; i+=2) {
//            lastRoof[index++] = hash(n[i], n[i+1]);
//        }
////        return getRoot(lastRoof);
//    }

    int hash(int left, int right){
        return 0;
    }

    static int fileRootHash = 0x111111;

    /**
     *
     * @param file
     * @param hashBytes
     * @return
     */
//    public boolean verifyFile(byte[] file,byte[][] hashBytes){
//
//
//
//    }

    byte[] hash(byte[] file){
        return new byte[1];
    }

    /**
     * 找到波峰值
     * @param array 不重复正整数序列，满足 length>=3, a[0] < a[1], a[n-1]>a[n]
     * @return 任一波峰值 平均时间复杂度 logN
     */
    public int findWaveCrest(int[] array){
        if (array == null || array.length < 3){
            return -1;
        }
        return findWaveCrest(array, 0, array.length-1);
    }

    private int findWaveCrest(int[] array, int left, int right){
        int mid = (left+right)/2;
        if (array[mid] > array[mid-1] && array[mid] > array[mid+1]){
            //满足波峰条件
            return array[mid];
        }
        if (array[mid] < array[mid-1]){
            //左边一定有波峰
            return findWaveCrest(array,left, mid-1);
        }
        //右边一定有波峰
        return findWaveCrest(array, mid+1, right);
    }

    public static void main(String[] args) {

        System.out.println(5^0);
        System.out.println(5^5);
        System.out.println(5&0);
        System.out.println(5|0);

        System.out.println(5&5);
        System.out.println(5|5);



//        int[] arr = {0, 1, 2, 2, 5, 7, 9, 0};
//        System.out.println(new ArraysTest().findWaveCrest(arr));
//
//        String str2 = new String("abcd");
//
//        String str1 = "abcd";
//        String str3 = "abcd";
//        System.out.println(str1==str2);//false
//        System.out.println(str1==str3);//true
//
//        System.out.println(5^0);

//        String str1 = "str";
//        String str2 = "ing";
//        String str3 = "str" + "ing";
//        String str4 = str1 + str2;
//        System.out.println(str3 == str4);//false
//
//        String str5 = "string";
//        System.out.println(str3 == str5);//true
    }






}
