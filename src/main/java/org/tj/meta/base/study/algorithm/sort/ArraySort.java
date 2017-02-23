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
        if (array == null){
            return array;
        }
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
    public static int[] quickSort(int[] array){
        quickSort1(array,0,array.length-1);
        return array;
    }

    public static void quickSort1(int[] array,int left,int right){
        if (left>=right){
            return;
        }
        int baseValue = array[left];
        int baseIndex = left;
        while (left<right){
            while (array[right] >= baseValue && left < right)
                right--;
            while (array[left] <= baseValue && left < right)
                left++;
            swap(array,left,right);
        }
//        swap(array,baseIndex,left);
        array[baseIndex] = array[left];
        array[left] = baseValue;
        quickSort1(array,baseIndex,left);
        quickSort1(array,left+1,right);
    }

//    public static void quickSort1(int[] array,int start,int end){
//        System.out.println(start+"  "+end);
//        if (start == end){
//            return ;
//        }
//        int i = start + 1;
//        int j = end;
//        int baseValue = array[start];
//        while (i<j){
//            while (array[j]>=baseValue){
//                j--;
//            }
//
//            while (array[i]<baseValue && i<j){
//                i++;
//            }
//
//            System.out.println(i+" "+j);
//            swap(array,i,j);
//        }
//        swap(array,start,i);
//        quickSort1(array,start,i);
//        quickSort1(array,i+1,end);
//    }


    /**
     * 冒泡 n2
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        if (array == null){
            return array;
        }
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i; j--) {
                if (array[j]<array[j-1]){
                    swap(array,i,j);
                }
            }
        }
        return array;
    }

    /**
     * 选择排序 n2  每次选择最小的  也算冒泡的一种  但是减少了交换次数，只有n-1次交换。
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array){
        if (array == null){
            return array;
        }
        for (int i = 0; i < array.length -1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                swap(array,i,minIndex);
            }
        }
        return array;
    }

    /**
     * 计数排序 n 但是对数字有要求
     * @param array
     * @return
     */
    public static int[] countSort(int[] array){
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[maxIndex] < array[i]){
                maxIndex = i;
            }
        }
        int[] array1 = new int[array[maxIndex]+1];
        for (int i = 0; i < array.length; i++) {
            array1[array[i]]+=1;
        }
        int[] newArray = array;
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i]; j++) {
                newArray[index++] = i;
            }
        }
        return newArray;
    }

    /**
     * 归并排序
     * @param array
     */
    public static int[] mergeSort(int[] array){
//        divice(array,0,array.length-1);
        mergeSort1(array,0,array.length-1);
        return array;
    }

    public static void mergeSort1(int[] array,int left,int right){
        int mid = (left+right)/2;
        if (left<right){
            mergeSort1(array,left,mid);
            mergeSort1(array,mid+1,right);
            mergeArray(array,left,right);
        }
    }

    public static void mergeArray(int[]array,int left,int right){
        int[] tmp = new int[right-left+1];
        int mid = (left+right)/2;
        int index = 0;
        int i = left;
        int j = mid+1;
        while (i<=mid && j<=right){
            if (array[i] < array[j]){
                tmp[index++] = array[i++];
            }else {
                tmp[index++] = array[j++];
            }
        }
//        把左边的放入tmp
        while (i<=mid){
            tmp[index++] = array[i++];
        }
        while (j<=right){
            tmp[index++] = array[j++];
        }
        for (int k = 0; k < tmp.length; k++) {
            array[left++] = tmp[k];
        }
    }


//    public static void merge(int[] array,int left,)


    static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void printArray(int[] t){
        if (t == null){
            System.out.println(t);
            return;
        }
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]+"  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array = RandomUtil.randomIntArray(100,10);
        printArray(array);
//        int[] array1 = {43,  74,  72,  9,  10,  43 , 93 , 15  ,36  ,0 };
//        bubbleSort(array);
//        printArray(countSort(array));
        printArray(mergeSort(array));
        printArray(array);
//        printArray(straightInsertionSort(array));
//        printArray(array);
    }
}
