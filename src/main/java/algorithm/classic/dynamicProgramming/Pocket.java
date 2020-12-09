package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 有一个神奇的口袋 总容积40
 * <p>
 * 有N个想得到的物品 每个物品的体积分别是 a1、a2、... an;
 * <p>
 * 如果选出的物品总体积是40则得到这些物品 问有几种解法？
 */
public class Pocket {

    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * 递归解决
     *
     * @param i
     * @param weight
     * @return
     */
    public static int f(int i, int weight) {
        if (weight == 0) return 1;
        if (i < 0) return 0;
        return f(i - 1, weight) + f(i - 1, weight - a[i]);
    }

    /**
     * 动规解决
     * int[i][j] i 代表体积 j代表前j个元素
     * <p>
     * f(i,j)   =1  i==0
     * =f(i,j-1) + f(i-a[j],j-1)  i>0
     *
     * @param weight
     * @return
     */
    public static int d(int weight) {
        int[][] result = new int[weight + 1][10];
        for (int i = 0; i < 10; i++) {
            result[0][i] = 1;
        }
        if (a[0] <= weight) {
            result[a[0]][0] = 1;
        }

        for (int i = 1; i <= weight; i++) {
            for (int j = 1; j < 10; j++) {
                result[i][j] = result[i][j - 1];
                if (i - a[j] >= 0) {
                    result[i][j] += result[i - a[j]][j - 1];
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            StdOut.println(i + "---" + Arrays.toString(result[i]));
        }
        return result[weight][9];
    }


    public static void main(String[] args) {
        StdOut.println(f(9, 40));//9
        StdOut.println(d(40));
    }

}
