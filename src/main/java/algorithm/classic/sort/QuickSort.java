/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.sort;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author shiwenxiang
 * @version : QuickSort.java, v0.1 2020/11/20 shiwenxiang Exp $$
 */
public class QuickSort {


    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(a, start, end);
        quickSort(a, start, mid - 1);
        quickSort(a, mid + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int gap = a[end];
        int point = start;
        for (int i = start; i < end; i++) {
            if (a[i] < gap) {
                int temp = a[i];
                a[i] = a[point];
                a[point] = temp;
                point++;
            }
        }
        int temp = a[point];
        a[point] = gap;
        a[end] = temp;
        return point;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 55, 4, 3, 2, 1};
        quickSort(a, 0, a.length - 1);
        StdOut.println((Arrays.toString(a)));
    }

}
