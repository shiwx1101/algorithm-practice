/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.recursion;

import edu.princeton.cs.algs4.StdOut;

/**
 * 汉诺塔问题
 *
 * @author shiwenxiang
 * @version : Hanoi.java, v0.1 2020/11/17 shiwenxiang Exp $$
 */
public class Hanoi {

    public static void hanoi(int n, char src, char mid, char dest, int num) {
        if (n == 1) {
            StdOut.println(num + " : " + src + "--->" + dest);
            return;
        }
        hanoi(n - 1, src, dest, mid, num);
        StdOut.println(num + n - 1 + " : " + src + "--->" + dest);
        hanoi(n - 1, mid, src, dest, num);
    }

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C', 1);
    }


}
