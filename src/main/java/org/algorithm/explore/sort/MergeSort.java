package org.algorithm.explore.sort;

import java.util.Arrays;

class MergeSort {

    public void mergeSort(int[] a,int s,int e){
        if(s>=e)return;
        int mid = (s+e)/2;
        mergeSort(a, s, mid);
        mergeSort(a, mid+1, e);
        merge(a,s,mid,e);

    }

    private void merge(int[] a,int s,int mid,int e){
        int[] tmp = new int[e-s+1];
        int i = 0;
        int j = s;
        int k = mid+1;
        while(j<=mid&&k<=e){
            if(a[j]<a[k]){
                tmp[i++] = a[j++];
            }else{
                tmp[i++] = a[k++];
            }
        }

        if(s<=mid){
            for (int k2 = j; k2 <= mid; k2++) {
                tmp[i++] = a[k2];
            }
            
        }
        if(k<=e){
            for (int k2 = k; k2 <= e; k2++) {
                tmp[i++] = a[k2];
            }
        }

        for (int k2 = s; k2 <= e; k2++) {
            a[k2] = tmp[k2-s];
        }
    }


    public static void main(String[] args) {
        int[] m = {1,2,3,4,5,5,4,3,2,1};
        new MergeSort().mergeSort(m, 0, m.length-1);;
        System.out.println(Arrays.toString(m));
    }
}