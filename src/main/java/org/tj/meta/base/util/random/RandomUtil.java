package org.tj.meta.base.util.random;

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

    public static void printArray(int[] t){
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(randomIntArray(1000,30));
    }
}
