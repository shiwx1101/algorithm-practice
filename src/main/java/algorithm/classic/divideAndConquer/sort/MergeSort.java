/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.divideAndConquer.sort;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author shiwenxiang
 * @version : MergeSort.java, v0.1 2020/11/20 shiwenxiang Exp $$
 */
public class MergeSort {

    public static void mergeSort(int[] a, int start, int end, int[] b) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(a, start, mid, b);
        mergeSort(a, mid + 1, end, b);
        merge(a, start, mid, end, b);
    }

    private static void merge(int[] a, int start, int mid, int end, int[] b) {
        int index = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                b[index++] = a[i++];
            } else {
                b[index++] = a[j++];
            }
        }
        while (i <= mid) {
            b[index++] = a[i++];
        }
        while (j <= end) {
            b[index++] = a[j++];
        }
        for (int k = start; k <= end; k++) {
            a[k] = b[k - start];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,55,4,3,2,1};
        int[] b = new int[100];
        mergeSort(a,0,a.length-1,b);
        StdOut.println((Arrays.toString(a)));
    }
}
