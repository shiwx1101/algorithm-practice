package algorithm.explore.recursion;

/**
 * 14523
 * 14526
 * 13524
 * 13524
 * <p>
 * 找出第K大的元素
 */
public class FindKItem {

    public int find(int[] a, int k) {
        int length = a.length;

        if (k < 1 || k > length) {
            throw new IllegalArgumentException();
        }

        int index = length - 1;

        return findK(a, 0, index, length - k);
    }

    private int findK(int[] a, int from, int to, int k) {
        int pivot = a[to];
        int i = from;
        int j = from;

        for (; i < to; i++) {  //原地分区！！
            if (a[i] < pivot) {
                swap(a, i, j);
                j++;
            }
        }
        swap(a, j, to);
        if (j == k) {
            return a[j];
        } else if (j > k) {
            return findK(a, from, j - 1, k);
        } else {
            return findK(a, j + 1, to, k);
        }

    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 1, 2, 10, 6, 9, 8, 7};
        System.out.println(new FindKItem().find(a, 1));
    }

}
