package algorithm.explore.comlexity.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class E1_4_11 {
    private int[] a;

    public E1_4_11(int[] keys) {
        //保护性复制
        this.a = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    //给出指定键的出现次数

    /**
     * 时间复杂度为2*LgN ~ lgN
     *
     * @param key
     * @return
     */
    public int howMany(int key) {
        int i = rankLeft(key);
        int j = rankRight(key);
        if (i == -1 && j == -1) {
            return 0;
        } else {
            return j - i + 1;
        }
    }

    //最左边一个
    private int rankLeft(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                if (mid >= 1 && a[mid - 1] == key) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    //最右边一个
    private int rankRight(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                if (mid <= a.length - 2 && a[mid + 1] == key) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    private int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5};
        E1_4_11 e1_4_11 = new E1_4_11(a);
        StdOut.print(e1_4_11.howMany(5));
    }
}
