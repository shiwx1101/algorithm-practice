package algorithm.explore.comlexity.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 有序数组 双指针夹逼法  普遍用于有序数组排序 查找
 * <p>
 * TwoSum 的线性级别算法
 */
public class E1_4_15 {

    private int[] a;

    public E1_4_15(int[] items) {
        this.a = items;
        Arrays.sort(a);
    }

    //循环内总共执行N次或者更少，因为 碰到相同的 头尾指针都会向里面靠，
    //combination 函数复杂度也不花超过N
    //所以大致执行次数不会超过 2*N  复杂度为N
    public int twoSum() {
        //头尾指针
        int i = 0;
        int j = a.length - 1;
        int count = 0;
        while (a[i] < 0 && a[j] > 0 && i < j) {
            if (a[i] + a[j] > 0) {
                j--;
            } else if (a[i] + a[j] < 0) {
                i++;
            } else {//等于0
                int pp = 1;//正数的数量
                int np = 1;//负数的数量
                while (i + 1 < a.length && a[i] == a[i + 1]) {
                    i++;
                    np++;
                }
                while (j - 1 >= 0 && a[j] == a[j - 1]) {
                    j--;
                    pp++;
                }
                i++;
                j--;
                count += np * pp;
            }
        }
        count += combination(j - i + 1, 2);//处理为0的情况
        return count;
    }

    /**
     * 复杂度为N^2
     *
     * @return
     */
    public int threeSum() {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int lo = i + 1, hi = a.length - 1; lo < hi; ) {
                if (a[i] + a[lo] + a[hi] > 0) {
                    hi--;
                } else if (a[i] + a[lo] + a[hi] < 0) {
                    lo++;
                } else {
                    //这边暂时不考虑重复
//                    lo++;
//                    hi--;
//                    count++;
                    //考虑重复

                    int pp = 1;//正数的数量
                    int np = 1;//负数的数量
                    boolean flag = false;  //a[hi] a[hi] 是否相同
                    if (a[lo] == a[hi]) flag = true;
                    while (hi - 1 > i && a[hi] == a[hi - 1]) {
                        hi--;
                        pp++;
                    }
                    while (lo < a.length - 1 && a[lo] == a[lo + 1]) {
                        lo++;
                        np++;
                    }
                    lo++;
                    hi--;
                    if (flag) { //重复情况要考虑2种 1是a[hi] a[hi]相同  那是C **  //不同那就是相乘
                        count += combination(pp, 2);
                    } else {
                        count += np * pp;
                    }
                }
            }
        }
        return count;
    }


    /**
     * C N M 排列组合
     *
     * @param N
     * @param M
     * @return
     */
    private int combination(int N, int M) {
        int q = 1;
        int k = 1;
        for (int i = N; i > N - M; i--) {
            q *= i;
        }
        for (int i = 1; i <= M; i++) {
            k *= i;
        }
        return q / k;
    }

    public static void main(String[] args) {
        int[] a = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        E1_4_15 e1_4_15 = new E1_4_15(a);
        StdOut.println(e1_4_15.twoSum());
        StdOut.println("-------------------------");
        int[] b = {-2, 0, 0, 0, 1, 1, 1, 1, 2, 2};
        E1_4_15 e1415 = new E1_4_15(b);
        StdOut.println(e1415.threeSum());
    }
}
