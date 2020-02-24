package org.algorithm.explore.sort;

import java.util.Arrays;

class SelectSort {

    public int[] selectSort(int[] a){

        int n = a.length;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if(a[minIndex]>a[j]){
                    minIndex = j;
                }
            }
            tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] m = {1,2,3,4,5,5,4,3,2,1};
        int[] mm = new SelectSort().selectSort(m);
        System.out.println(Arrays.toString(mm));
    }




}