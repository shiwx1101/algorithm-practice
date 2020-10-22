package algorithm.explore.comlexity.practice;

/**
 * 修改二分法 返回所匹配的最小元素
 */
public class E1_4_10 {

    public static int rank(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (a[mid] == key) {
                if (mid - 1 > 0 && a[mid - 1] == key) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 2, 2, 3, 3, 4, 4, 5};
        System.out.println(rank(a, 4));
    }
}
