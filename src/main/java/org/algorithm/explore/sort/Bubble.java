package org.algorithm.explore.sort;
class Bubble{


    public int[] bubbleSort(int[] items){
        int n = items.length;
        if(n<=1)return items;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if(items[j]>items[j+1]){
                    tmp = items[j+1];
                    items[j+1] = items[j];
                    items[j] = tmp;
                    flag = true;
                }
            }
            if(!flag)break;
        }
        return items;
    }


}