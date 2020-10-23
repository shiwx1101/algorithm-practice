package algorithm.explore.comlexity;

import algorithm.explore.binarysearch.BinarySearch;

import java.util.Arrays;

public class ThreeSumFaster {

    public static int count2(int[] a) {
        Arrays.sort(a);
        int length = a.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (BinarySearch.binarySearch(a, -a[i] - a[j]) > i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(count2(a));
    }
}
