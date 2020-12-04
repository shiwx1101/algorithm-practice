/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * V(m,n) m符号数 n数字数
 * V(m,n)   if(m >= n)  NaN
 * if(m = 0)  n个数字构成的整数
 * else   V(m,n) =  MIN [  V(m-1,i) + Num(i+1,n)  ····  i(m ~~ n-1)  ]
 *
 * @author shiwenxiang
 * @version : BestAdditionExpression.java, v0.1 2020/12/3 shiwenxiang Exp $$
 */
public class BestAdditionExpression {

    public static void find(int m, int[] a, int n) {

        int[][] status = new int[m + 1][n + 1];

//      初始化Number
        int[][] num = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                if (i == j) {
                    num[i][j] = a[j - 1];
                } else {
                    num[i][j] = num[i][j - 1] * 10 + a[j - 1];
                }
            }
        }
        StdOut.println("----初始化数组----------");
        for (int i = 0; i < num.length; i++) {
            StdOut.println(Arrays.toString(num[i]));
        }


        for (int i = 2; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                min = Math.min(min, num[1][j] + num[j + 1][i]);
            }
            status[1][i] = min;
        }


        StdOut.println("----初始化状态----------");

        for (int i = 0; i < status.length; i++) {
            StdOut.println(Arrays.toString(status[i]));
        }

        for (int i = 2; i < m + 1; i++) {  //符号个数
            for (int j = i + 1; j < n + 1; j++) { //字符个数
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k <= j; k++) {
                    min = Math.min(min, status[i - 1][k - 1] + num[k][j]);
                }
                status[i][j] = min;
            }
        }

        StdOut.println("----结果-------");

        for (int i = 0; i < status.length; i++) {
            StdOut.println(Arrays.toString(status[i]));
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        find(8, a, a.length);
    }
}
