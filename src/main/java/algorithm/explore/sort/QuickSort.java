package algorithm.explore.sort;

import java.util.Arrays;

class QuickSort{
    
    private int[] m = {1,2,3,4,5,5,4,3,2,1};

    public void quickSort(int[] a,int s,int e){
        if(s>=e)return;
        int q = partition(a, s, e);
        quickSort(a,s,q-1);
        quickSort(a, q+1, e);
    }

    public int partition(int[] a,int s,int e){
        int midPoint = a[e];
        int point = s;

        for (int i = s; i <= e ; i++) {
            if(a[i]<midPoint){
                int tmp = a[i];
                a[i] = a[point];
                a[point] = tmp;
                point++;
            }
        }
        int tmp = a[point];
        a[point] = midPoint;
        a[e] = tmp; 
        return point;
    }

    public static void main(String[] args) {
        QuickSort qs =  new QuickSort();
        qs.quickSort(qs.m, 0, qs.m.length-1);
        System.out.println(Arrays.toString(qs.m));
    }

}