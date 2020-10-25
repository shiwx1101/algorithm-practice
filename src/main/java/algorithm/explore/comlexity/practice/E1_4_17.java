package algorithm.explore.comlexity.practice;

import edu.princeton.cs.algs4.StdOut;

/**
 * 最遥远的一对值 给定一个含N个double的值数组a[],其中找到最遥远的一对值。要求最坏复杂度N
 */
public class E1_4_17 {

    double a[];

    public E1_4_17(double[] a) {
        this.a = a;
    }

    public double[] furthest() {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        return new double[]{min, max};
    }

    public static void main(String[] args) {
        double[] a = {-100.5,200,0,577,-621,820};
        E1_4_17 e1_4_17 = new E1_4_17(a);
        StdOut.println(e1_4_17.furthest()[0]);
        StdOut.println(e1_4_17.furthest()[1]);
    }
}
