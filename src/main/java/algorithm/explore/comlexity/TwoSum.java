package algorithm.explore.comlexity;

/**
 * int N = a.length;
 * int count = 0;                       A              1                    t1
 * for (int i = 0; i < N; i++)          B              N                    t2*N
 * for (int j = i + 1; j < N; j++)      C              1+2+**N-1(等比数列)
 * if (a[i] + a[j] == 0)                               (N-1)*N/2            t3*(N-1)*N/2
 * count++;                             D              x(取决于输入的a)       t4*x
 *
 *  总时间                                                                   1/2 * t3 * N^2 + (t2 - 1/2 * t3)*N + t4 * x + t1
 *  近似                                                                     1/2 * t3 * N^2
 *  增长级数                                                                   N^2
 */
public class TwoSum {

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
