package algorithm.explore.sort;

import java.util.Arrays;

class InsertSort{

    public int[] insertSort(int[] items){
        int n = items.length;
        for (int i = 1; i < n; i++) {
            int value = items[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if(items[j]>value){
                    items[j+1] = items[j];
                }else{break;}
            }
            items[j+1] = value;
        }
        return items;
    }

    public static void main(String[] args) {
        int[] m = {1,2,3,4,5,5,4,3,2,1};
        int[] mm = new InsertSort().insertSort(m);
        System.out.println(Arrays.toString(mm));
    }





}