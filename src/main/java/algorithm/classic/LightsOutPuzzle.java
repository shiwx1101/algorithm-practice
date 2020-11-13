package algorithm.classic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Collections;

/**
 * 熄灯问题
 */
public class LightsOutPuzzle {

    int[][] lights;

    int[][] action;

    int[][] result;

    public LightsOutPuzzle(int[][] lights, int[][] action, int[][] result) {
        this.lights = lights;
        this.action = action;
        this.result = result;
    }

    void action() {
        int length = lights[0].length;
        int max = (int) (Math.pow(2, length) - 1); //第一列 最大的可能0 -  n^2 -1
        for (int i = 0; i < max; i++) {
            int[] solutionArray = getByteItem(i, length);
            int[] temp = solutionArray;
            for (int j = 0; j < lights.length; j++) {
                for (int k = 0; k < lights[j].length; k++) {
                    result[j][k] = xor(temp[k] , lights[j][k]); //给当前灯赋值
                    if (j > 0) {
                        result[j - 1][k] = xor(temp[k], lights[j - 1][k]); //给上一层灯赋值
                    }
                    if (k > 0) {//
                        result[j][k - 1] = xor(temp[k], lights[j][k - 1]); //给左边灯赋值
                    }
                    if (k < lights[j].length - 1) {//
                        result[j][k + 1] = xor(temp[k], lights[j][k + 1]); //给右边灯赋值
                    }
                    if (j < lights.length - 1) {//没到最后一层
                        result[j + 1][k] = xor(temp[k], lights[j + 1][k]); //给处理下一层
                    }
                }
                temp = result[j];  //引用问题
                action[j] = temp;
                if (j == lights.length - 1) {
                    if (Arrays.stream(temp).boxed().reduce(Integer::sum).get() == 0) {
                        StdOut.println(Arrays.toString(solutionArray) + "找到了");
                    }
                    StdOut.println("完事了");
//                        return;
                }
            }

        }
    }

    private static int xor(int i, int j) {
        if (i == j) {
            return 0;
        }
        return 1;
    }

    private static int[] getByteItem(int solution, int length) {
        int res[] = new int[length];
        for (int i = 0; i < length; i++) {
            if (solution == 0) {
                return res;
            }
            res[i] = solution % 2;
            solution = solution / 2;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] lights = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int[][] actions = new int[3][3];
        int[][] result = new int[3][3];
        LightsOutPuzzle lightsOutPuzzle = new LightsOutPuzzle(lights, actions, result);
        lightsOutPuzzle.action();

    }


}
