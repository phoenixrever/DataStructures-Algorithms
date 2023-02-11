package com.phoenixhell;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author チヨウ　カツヒ
 * @date 2023-01-29 16:01
 */
public class test {

    @Test
    public void testBubbleSort() {
        int[] a = new int[]{6, 3, 7, 5, 9, 1, 2, 4, 8,};
        //bubbleSort(a);
        //selectSort(a);
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void bubbleSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    count++;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if (count == 0) {
                System.out.println(count);
                break;
            }
        }
    }

    public void selectSort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int min = a[i];
            int minIndex=i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min=a[j];
                    minIndex=j;
                }
            }
            //一开始的i就是最小值的时候不需要交换
            if(minIndex!=i){
                a[minIndex] = a[i];
                a[i] = min;
            }
        }
    }

    //(6), 3, 7, 5, 9, 1, 2, 4, 8,
    public void insertSort(int[] a) {
        for (int i =1; i < a.length-1; i++) {
            for (int j = i; j >0&& a[j]<a[j-1]; j--) {
                int temp=a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
            }
        }
    }
}
