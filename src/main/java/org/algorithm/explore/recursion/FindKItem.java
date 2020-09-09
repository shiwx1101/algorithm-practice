package org.algorithm.explore.recursion;

/**
 *
 * 14523
 * 14526
 * 13524
 * 13524
 *
 * 找出第K大的元素
 */
public class FindKItem {

    public int find(int[] a, int k) {
        int length = a.length;

        if (k < 1 || k > length) {
            throw new IllegalArgumentException();
        }

        int index = length - 1;

        return findK(a, 0, index, k);
    }

    private int findK(int[] a, int from, int to, int k) {

        int point = to;
        int f = a[point];

        for (int i = 0; i <= to - from; i++) {
            if(a[i]>f){

            }
        }


        return 0;
    }

}
