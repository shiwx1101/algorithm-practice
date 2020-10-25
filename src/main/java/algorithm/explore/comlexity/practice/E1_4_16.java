package algorithm.explore.comlexity.practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 最接近的一对值 给定一个含N个double的值数组a[],其中找到最近的一对值。要求最坏复杂度NlgN
 */
public class E1_4_16 {


    double a[];

    public E1_4_16(double[] a) {
        if (a.length == 1) {
            throw new IllegalArgumentException();
        }
        this.a = a;
    }

    public double[] closest() {
        Arrays.sort(a);
        double[] result = new double[2];
        double min = Double.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] < min) {
                min = a[i + 1] - a[i];
                result[0] = a[i];
                result[1] = a[i + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        double[] a = {-100.5, 200, 0, 577, -621, 820};
        E1_4_16 e1_4_16 = new E1_4_16(a);
        StdOut.println(e1_4_16.closest()[0]);
        StdOut.println(e1_4_16.closest()[1]);

    }

}
