package algorithm.explore.comlexity.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 编写一个程序有序打印给定的两个有序数组（含N个int值）中的所有公共元素，要求最坏复杂度为N
 */
public class E1_4_12 {

    private int[] a;

    private int[] b;

    public E1_4_12(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        Arrays.sort(a);
        Arrays.sort(b);
    }

    /**
     * 时间复杂度最坏为 M+N(都不一样)   最好为min(M,N)(a或者b中的元素全部一致)
     */
    public void showCommonInt() {
        int N = a.length;
        int M = b.length;
        int i = 0;
        int j = 0;
        while (i < N && j < M) {
            //防止重复计算的
            if (i != 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j != 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                i++;
                j++;
                StdOut.print(a[i - 1] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1, 2, 3, 4, 5, 5, 5, 6, 6};
        int[] b = {0, 1, 2, 3, 3, 3, 3, 4, 4, 4, 5, 6};
        E1_4_12 e1_4_12 = new E1_4_12(a, b);
        e1_4_12.showCommonInt();
    }


}
