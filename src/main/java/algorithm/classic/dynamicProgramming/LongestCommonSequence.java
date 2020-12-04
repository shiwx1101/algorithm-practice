package algorithm.classic.dynamicProgramming;

import edu.princeton.cs.algs4.StdOut;

/**
 * 最长公共子序列
 * a[] b[]
 * <p>
 * 状态设计
 * <p>
 * maxLen[i][j] 表示 a的左边i个字符 和 b的左边个字符形成的最长公共子串的长度
 * <p>
 * 显然 maxLen[i][0] = 0 maxLen[0][j] = 0
 * <p>
 * 状态转移: 当a[i - 1] == b[i - 1]     maxLen[i][j] = maxLen[i-1][j-1] + 1;
 * 状态转移: 当a[i - 1] != b[i - 1]     maxLen[i][j] = Max(maxLen[i-1][j] , maxLen[i][j-1])
 */
public class LongestCommonSequence {


    public static int find(char[] a, char[] b) {
        int n = a.length;
        int m = b.length;
        int[][] status = new int[n + 1][m + 1];  //左边第0个到第n个 总共n + 1  || m + 1

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    status[i][j] = status[i - 1][j - 1] + 1;
                } else {
                    status[i][j] = Math.max(status[i][j - 1], status[i - 1][j]);
                }
            }
        }
        return status[n][m];
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'f', 'b', 'c'};
        char[] b = {'a', 'b', 'f', 'c', 'a', 'b'};
        StdOut.println(find(a, b));

    }
}
