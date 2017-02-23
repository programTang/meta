package org.tj.meta.base.util.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 001 on 17/2/4.
 */
public class RandomUtil {

    public static int[] randomIntArray(int max,int number){
        int[] array = new int[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            array[i] = random.nextInt(max);
        }
        return array;
    }

    /**
     * 写一个函数，它的作用是接受一个整数(假设为length)，返回一个数组，数组的长度为length，数组中的内容为随机的0至(length-1)的值，并且不能重复。比如length为5的话，数组可能是[1,0,3,2,4]。
     * 思路：构建一个set，然后每次随机生成数字跟set比较，包含的话重新生成，不包含则放入数组，这也是一种思路，但是如果length很大时候，后期随机量的生成工作巨大
     * 所以如果有一个已经包含0-length的数据，然后每次都从中随机移除一个放入数组，借助list的remove可以很好的实现该效果.
     * @param length
     */
    public static int[] randIntArray(int length){
        int array[] = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = list.remove(random.nextInt(length-i));
        }
        return array;
    }


    public static void printArray(int[] t){
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        printArray(randomIntArray(1000,30));
       printArray(randIntArray(1000));
//        Set
        final StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder = new StringBuilder();
        stringBuilder.append("xxx");
        StringBuilder stringBuilder1 = stringBuilder;
        stringBuilder1 = new StringBuilder();
    }
}
