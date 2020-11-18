/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.classic.recursion;

import edu.princeton.cs.algs4.StdOut;

/**
 * N节台阶 1步2步  走法
 * <p>
 * 递推公式 f(n) = f(n-1) + f(n-2)
 *
 * @author shiwenxiang
 * @version : Step.java, v0.1 2020/11/18 shiwenxiang Exp $$
 */
public class Step {

    public static int walk(int k) {
        if (k < 0) return 0;
        if (k == 0) return 1;
        return walk(k - 1) + walk(k - 2);
    }

    public static void main(String[] args) {
       StdOut.println(walk(5));
    }



}
