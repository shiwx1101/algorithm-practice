/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.recursion;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * //终止条件
 * //把问题分成更小的子问题
 * //有递  有归（该往哪里归？）
 *
 * @author shiwenxiang
 * @version : NQueen.java, v0.1 2020/11/18 shiwenxiang Exp $$
 */
public class NQueen {

    static int[] solution = new int[8];
    ; //第几行放什么位置

    static int N = 8;

    public NQueen(int[] solution) {
    }

    public static void sol(int k) {
        if (k == N) {
            StdOut.println(Arrays.toString(solution));
            return;
        }

        for (int i = 0; i < N; i++) {  //k行所有的情况
            int j = 0;
            for (; j < k; j++) { // 前面的行
                if (solution[j] == i || Math.abs(j - k) == Math.abs(solution[j] - i)) {
                    break;
                }
            }
            if (j == k) {
                solution[k] = i;
                sol(k + 1);
            }
        }

    }

    public static void main(String[] args) {
        sol(0);
    }
}
