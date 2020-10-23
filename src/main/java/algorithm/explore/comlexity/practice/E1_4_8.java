package algorithm.explore.comlexity.practice;

import java.util.Arrays;

/**
 * 编写一个程序 计算相等的整数对
 */
public class E1_4_8 {

    /**
     * N^2 复杂度
     *
     * @param a
     * @return
     */
    public static int count(int[] a) {
        int length = a.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 最坏的情况下 所有元素都相同 复杂度是N^2
     * <p>
     * 最好的情况下都不同 NlgN 只需要考虑排序的复杂度
     * <p>
     * 通常在a里面元素均匀分布的情况 每个内循环也只会计算若干次
     * <p>
     * 所以一般情况下复杂度 为 NlgN + k*N ~ NlgN
     * <p>
     * TODO 其中 while 循环执行的次数取决于输入的模型，取决于输入相同值的数量 和相同值出现的次数
     * <p>
     * 比如10个数    1111122222 while里面 共执行 5*4 /2 * 2= 20 次
     * 如果10个1     1111111111 while里面 共执行你 10* 9 /2 = 45次
     * 如果1到10     12345678910 while 执行10次 while里面执行0次
     * <p>
     * 对于最坏的情况也还是count中的最好情况
     *
     * @param a
     * @return
     */
    public static int count2(int[] a) {
        Arrays.sort(a);
        int length = a.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            while (j < length && a[i] == a[j]) {
                j++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 1};
        System.out.println(count(a));
        System.out.println(count2(a));
    }


}
