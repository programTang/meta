package org.tj.meta.base.util;

public class ArraysTest {

    public int[] mergeArray(int[] array1 , int[] array2){
        if (array1 == null && array2 != null){
            return array2;
        }else if (array1 != null && array2 == null){
            return array1;
        }else if (array1 == null && array2 == null){
            return null;
        }

        //array1 的指针
        int index1 = 0;
        int index2 = 0;
        int[] array3 = new int[array1.length + array2.length];
        int index3 = 0;

        while (index1 < array1.length || index2 < array2.length){
            if (array1[index1] <= array2[index2]){
                array3[index3++] = array1[index1++];

            }else if (array1[index1] > array2[index2]){
                array3[index3++] = array2[index2++];
            }
        }

        if (index1 < array1.length){
            //数组1还有值 并且都比数组2大
            for (;index1 <= array1.length;){
                array3[index3++] = array1[index1++];
            }
        }
        if (index2 < array2.length){
            for (;index2 <= array2.length;){
                array3[index3++] = array2[index2++];
            }
        }
        return array3;
    }

    public static void main(String[] args) {

    }
}
