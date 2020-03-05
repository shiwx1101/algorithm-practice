package org.algorithm.explore.sort;

/**
 * 计数排序
 */

import java.util.Arrays;

class CountingSort{

    public void countingSort(int[] a, int range){

        int[] c = new int[range];

        int n = a.length;

        for (int i = 0; i < n; i++) {
            c[a[i]]+=1;
        }

        for (int i = 1; i < range; i++) {
            c[i] = c[i-1]+c[i];
        }

        int[] tmp = new int[n];

        for (int i = n-1; i >= 0; i--) {
            int index = c[a[i]]-1;
            tmp[index] = a[i];
            c[a[i]]--;
        }

        for (int i = 0; i < n; i++) {
            a[i] = tmp[i];
        }
        
    }

    public static void main(String[] args) {
        int[] m = {1,2,3,4,5,5,4,3,2,1};
        new CountingSort().countingSort(m, 6);;
        System.out.println(Arrays.toString(m));
    }
   
    

}