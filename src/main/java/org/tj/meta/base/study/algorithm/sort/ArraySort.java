package org.tj.meta.base.study.algorithm.sort;

import org.tj.meta.base.util.random.RandomUtil;

/**
 * Created by 001 on 17/2/4.
 * sort the int array
 */
public class ArraySort {

    /**
     * 直接插入排序 最坏复杂度 n2
     * 每一次都插入到一个已排序的序列中 稳定的排序
     * @param array
     * @return
     */
    public static int[] straightInsertionSort(int[] array){
        for (int i = 1;i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i]<array[j]){
                    int t = array[i];
                    for (int k = i; k > j; k--) {
                        array[k] = array[k-1];
                    }
                    array[j] = t;
                    continue;
                }
            }
        }
        return array;
    }

    /**
     * 希尔排序 插入排序的一种
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array){
//        增量gap
        for (int gap = array.length/2; gap > 1 ; gap/=2) {
//            直接插入排序
            for (int i = 0; i < gap; i++) {
                for (int j = i+gap; j < array.length; j += gap) {
                    if (array[j] < array[i]){
//                        插入  后面的向后移动
                        int t = array[j];
//                        for ()
                    }
                }
            }
        }
        return array;
    }


    /**
     * 平均n*lgn  最坏n2
     * @param array
     * @return
     */
//    public static int[] quickSort(int[] array){
//
//
//    }



    public static int[] bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i]>array[j]){
                    swap(array,i,j);
                }
            }
        }
        return array;
    }

    static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort1(int begin,int end, int[] array){
        if (begin<=end){
            return;
        }else {
            int value = array[begin];
            int index = begin;
            while (begin < end){
                if (value < array[end]){

                }
            }

        }
    }

    public static void printArray(int[] t){
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]+"  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array = RandomUtil.randomIntArray(100,10);
        printArray(array);
        bubbleSort(array);
        printArray(array);
//        printArray(straightInsertionSort(array));
//        printArray(array);
    }
}
