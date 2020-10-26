package algorithm.explore.comlexity.practice;

import edu.princeton.cs.algs4.StdOut;

/**
 * 数组局部最小元素 编写一个程序 含有N个不同元素的数组 找到一个局部最小的元素 满足 a[i+1] > a[i] <a[i-1]
 * <p>
 * 最坏的情况比较次数 2 * lgN
 * <p>
 * 这一题有点问题？根据条件编码
 * <p>
 * int[] a = {1,2,3,4,5,6,0,7,8}; 找不到解
 * <p>
 * int[] a = {10,2,3,4,5,6,0,7,8}; 找的到解 index = 1
 * <p>
 * TODO 此题有待解决
 */
public class E1_4_18 {


    private int[] a;

    public E1_4_18(int[] a) {
        this.a = a;
    }

    public int minimum() {
        if (a.length < 3) {
            throw new RuntimeException();
        }
        int lo = 0;
        int hi = a.length;
        while (hi > lo) {
            int mid = (lo + hi) / 2;
            if (mid == lo || mid == hi) {
                return -1;
            }
            if (a[mid - 1] > a[mid] && a[mid + 1] > a[mid]) {
                return mid;
            } else {
                if (a[mid - 1] > a[mid + 1]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10, 2, 3, 4, 5, 6, 0, 7, 8};
        E1_4_18 e1_4_18 = new E1_4_18(a);
        StdOut.println(e1_4_18.minimum());
    }

}
