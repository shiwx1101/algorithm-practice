package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

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
        if (i <= 0) return 0;
        return f(i - 1, weight) + f(i - 1, weight - a[i]);
    }



    public static void main(String[] args) {
        StdOut.println(f(9, 40));//9
    }

}
