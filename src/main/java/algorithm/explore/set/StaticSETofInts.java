package algorithm.explore.set;

import java.util.Arrays;

/**
 *
 */
public class StaticSETofInts {

    private int[] a;

    public StaticSETofInts(int[] keys) {
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

    private int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = (hi + lo) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] > key) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}
