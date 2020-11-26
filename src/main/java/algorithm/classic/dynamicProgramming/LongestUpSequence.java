/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 最长上升子序列
 *
 * @author shiwenxiang
 * @version : LongestUpSequence.java, v0.1 2020/11/26 shiwenxiang Exp $$
 */
public class LongestUpSequence {
    /**
     * 以a[i]为终点的最长子列的长度为b[i]
     *
     * @param a
     * @param b
     */
    public static void find(int[] a, int[] b) {
        Arrays.fill(b, 1);
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    b[i] = Math.max(b[i], b[j] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 5, 1, 6, 6, 4};
        int[] b = new int[a.length];
        find(a, b);
        StdOut.println(Arrays.toString(b));
    }

}
