package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;
import javafx.scene.paint.Stop;

/**
 * 滑雪问题
 * <p>
 * 1   2   3   4   5
 * 16  17  18  19  6
 * 15  24  25  20  7
 * 14  23  22  21  8
 * 13  12  11  10  9
 * <p>
 * f(i,j)代表从坐标ij的划到底部的最长距离 肯定是他周围比他矮的点的最大值+1;
 * <p>
 * f(i,j) = Max [f(i-1,j),f(i+1,j),f(i,j+1),f(i,j-1)] + 1     ;前提是周围的点存在;
 * <p>
 * 改进：
 * 递归形式，需要一个矩阵存储f(i,j)的值，在每次f(i,j)的时候查看是否有值，不需要重复计算
 */
public class Skiing {


    public static int f(int[][] height, int i, int j) {
        int top, button, left, right = 0;
        if (i == 0) {
            top = 0;
        } else {
            top = height[i][j] > height[i - 1][j] ? f(height, i - 1, j) : 0;
        }
        if (i == 4) {
            button = 0;
        } else {
            button = height[i][j] > height[i + 1][j] ? f(height, i + 1, j) : 0;
        }
        if (j == 0) {
            left = 0;
        } else {
            left = height[i][j] > height[i][j - 1] ? f(height, i, j - 1) : 0;
        }
        if (j == 4) {
            right = 0;
        } else {
            right = height[i][j] > height[i][j + 1] ? f(height, i, j + 1) : 0;
        }
        int max = Math.max(Math.max(left, right), Math.max(top, button)) + 1;
        return max;
    }

    public static void main(String[] args) {
        int[][] height = initData();
        StdOut.println(f(height, 2, 2));
    }

    private static int[][] initData() {
        return new int[][]{{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};
    }


}
