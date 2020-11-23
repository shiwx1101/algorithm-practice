package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

/**
 * recursion
 * <p>
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 */
public class NumberTriangle {

    int[][] a;

    //    public static int max(int[][] a, int i, int j) {
//        if (i == a.length - 1) {
//            return a[i][j];
//        }
//        return Math.max(max(a, i + 1, j), max(a, i + 1, j + 1)) + a[i][j];
//    }
//
//    public static void main(String[] args) {
//        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
//        StdOut.println(max(a, 0, 0));
//    }
//   动态规划 =》动规由递归而来。 只是把重复计算的给存了起来

    public static int max(int[][] a) {
        int maxIndex = a.length - 1;
        int[] res = a[maxIndex]; //最后一行用于存储之前的结果

        for (int i = maxIndex - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.max(res[j], res[j + 1]) + a[i][j];
            }
        }
        return res[0];
    }

    public static void main(String[] args) {
        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        StdOut.println(max(a));
    }


}
