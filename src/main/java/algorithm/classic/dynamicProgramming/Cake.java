package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.In;

/**
 * 得到m+1快蛋糕的最大面积的最小值
 */
public class Cake {


    //递归得到

    /**
     * 注意枚举各种情况
     *
     * @param w
     * @param h
     * @param m
     * @return
     */
    public static int cut(int w, int h, int m) {
        if (w * h - 1 < m) {
            return Integer.MAX_VALUE;
        }
        if (m == 0)
            return w * h;

        int top = Integer.MAX_VALUE;

        for (int i = 1; i < w; i++) {
            int top1 = -1;
            for (int k = 0; k <= m - 1; k++) {
                int cut = Math.max(cut(i, h, k), cut(w - i, h, m - 1 - k));
                top1 = Math.max(cut, top1);
            }
            top = Math.min(top, top1);
        }

        int left = Integer.MAX_VALUE;
        for (int i = 1; i < w; i++) {
            int left1 = -1;
            for (int k = 0; k <= m - 1; k++) {
                int cut = Math.max(cut(w, i, k), cut(w, h - i, m - 1 - k));
                left1 = Math.max(cut, 1);
            }
            left = Math.min(left, left1);
        }
        return Math.min(top, left);
    }

    public static int ways(int w, int h, int m) {
        int[][][] res = new int[w + 1][h + 1][m + 1];
        for (int i = 1; i <= w; i++) {
            for (int j = 0; j <= h; j++) {
                for (int k = 0; k <= m; k++) {
                    if (k == 0) {
                        res[i][j][k] = i * j;
                    } else if (i * j - 1 < k) {
                        res[i][j][k] = Integer.MAX_VALUE;
                    } else {
                        //枚举第一道横着切;
                        res[i][j][k] = Integer.MAX_VALUE;
                        for (int l = 1; l <= i - 1; l++) {
                            for (int n = 0; n <= k - 1; n++) {
                                res[i][j][k] = Math.min(res[i][j][k], Math.max(res[l][j][n], res[i - l][j][k - n - 1]));
                            }
                        }
                        //枚举第一道竖着切;
                        for (int l = 1; l <= j - 1; l++) {
                            for (int n = 0; n <= k - 1; n++) {
                                res[i][j][k] = Math.min(res[i][j][k], Math.max(res[i][l][n], res[i][j - l][k - n - 1]));
                            }
                        }
                    }
                }
            }
        }
        return res[w][h][m];
    }


    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(cut(7, 7, 7));
        System.out.println(System.currentTimeMillis()- s);
        System.out.println("===================");
        s = System.currentTimeMillis();
        System.out.println(ways(7, 7, 7));
        System.out.println(System.currentTimeMillis()- s);
    }
}
