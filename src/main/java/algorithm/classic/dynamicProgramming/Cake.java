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

    public static void main(String[] args) {
        System.out.println(cut(11, 11, 1));
    }
}
