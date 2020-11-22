package algorithm.classic.divideAndConquer;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 找出第前K大的数
 */

public class FindNoKItem {


    public static int[] find(int[] a, int k) {
        int start = 0;
        int end = a.length - 1;
        while (true) {
            int index = findIndex(a, start, end);
            if (index == k) {
                break;
            } else if (index > k) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = a[i];
        }
        return result;
    }

    public static int findIndex(int[] a, int start, int end) {
        int gap = a[start];
        int i = start;
        int j = end;
        while (i != j) {
            while (j > i && a[j] < gap) {
                j--;
            }
            swap(a, i, j);
            while (j > i && a[i] >= gap) {
                i++;
            }
            swap(a, i, j);
        }
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {10,62,33, 5, 55, 4, 3, 77, 1};
        int[] results = find(a, 5);
        Arrays.sort(results);
        StdOut.println(Arrays.toString(results));
    }

}
