/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * N个物品    体积w[0]...w[n-1]  价值V[0]..V[n-1]
 * M体积Bag
 * Bag所能装的最大价值
 *
 * @author shiwenxiang
 * @version : Bag.java, v0.1 2020/12/9 shiwenxiang Exp $$
 */
public class Bag {


    static int[] items = {1, 2, 4, 5, 6};
    static int[] values = {3, 4, 8, 9, 6};
    static int M = 9;//最大的容积
    static int maxValue = Integer.MIN_VALUE;

    /**
     * 递归 解法
     *
     * @param i
     * @param m
     * @param v
     * @param choose
     */
    public static void f(int i, int m, int v, String choose) {

        if (m == 9 || i == 5) {
            if (v > maxValue) {
                maxValue = v;
                StdOut.println(choose);
                StdOut.println("最大值" + maxValue);
            }
            return;
        }
        f(i + 1, m, v, choose);
        if (m + items[i] <= 9) {
            choose += "选" + i;
            f(i + 1, m + items[i], v + values[i], choose);
        }
    }

    /**
     * 动规解法
     * <p>
     * f（i，w）表示 第0到第i个物品选出一些物品（总体积m）放的最大总价值
     * 子问题 1.  不放第i个物品   f(i-1,w)
     * 2.  放第i个物品     f(i-1,w-weight[i]) + value[i]
     * <p>
     * 递推
     * status[i][w]       status[i][w] = 0                when  w = 0
     * status[i][w]       status[i][w] = value[0]         when  i = 0  and w = weight[0]
     * status[i][w]       Math.max( status[i-1][w] , status[i-1][w-weight[i]]+value[i] )
     */
    public static void d() {

        int[][] status = new int[5][10];
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[0].length; j++) {
                status[i][j] = -1;
            }
        }
        for (int i = 0; i < 5; i++) {
            status[i][0] = 0;
        }
        status[0][items[0]] = values[0];
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 10; j++) {
                status[i][j] = status[i - 1][j];
                if (j - items[i] >= 0) {
                    status[i][j] = Math.max(status[i][j], status[i - 1][j - items[i]] + values[i]);
                }
            }
        }
        StdOut.println(status[4][9]);


    }

    /**
     * @param weight
     * @return
     */
    public static int d2() {

        int[] result = new int[9 + 1];
        if (items[0] <= 9) {
            result[items[0]] = values[0];
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 9; j > 0; j--) {
                if (j - items[i] >= 0) {
                    result[j] = Math.max(result[j-items[i]] + values[i],result[j]);
                }
            }
        }
        StdOut.println(Arrays.toString(result));
        return result[9];
    }


    public static void main(String[] args) {
        f(0, 0, 0, "");
        d();
        StdOut.println(d2());
    }

}
