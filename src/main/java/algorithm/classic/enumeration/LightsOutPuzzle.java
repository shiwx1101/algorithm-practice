package algorithm.classic.enumeration;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

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
        tag:
        for (int i = 0; i < max; i++) {
            int[] solutionArray = getByteItem(i, length);
            int[] temp = solutionArray;
            copy(lights, result);
            StdOut.println("===============^");
            show(result);
            StdOut.println("===============v");
            for (int j = 0; j < result.length; j++) {
                action[j] = Arrays.copyOf(temp, temp.length);
                for (int k = 0; k < result[j].length; k++) {
                    result[j][k] = xor(temp[k], result[j][k]); //给当前灯赋值
                    if (j > 0) {
                        result[j - 1][k] = xor(temp[k], result[j - 1][k]); //给上一层灯赋值
                    }
                    if (k > 0) {//
                        result[j][k - 1] = xor(temp[k], result[j][k - 1]); //给左边灯赋值
                    }
                    if (k < result[j].length - 1) {//
                        result[j][k + 1] = xor(temp[k], result[j][k + 1]); //给右边灯赋值
                    }
                    if (j < result.length - 1) {//没到最后一层
                        result[j + 1][k] = xor(temp[k], result[j + 1][k]); //给处理下一层
                    }
                }
                temp = Arrays.copyOf(result[j], result[j].length);
                if (j == result.length - 1) {
                    if (Arrays.stream(temp).boxed().reduce(Integer::sum).get() == 0) {
                        StdOut.println("**" + Arrays.toString(solutionArray) + "找到了");
                        show(action);
//                        break tag;
                    }
                    copy(lights, result);
                    StdOut.println(Arrays.toString(solutionArray) + "没找到");
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

    /**
     * 对于引用的拷贝要注意
     *
     * @param source
     * @param target
     */
    private static void copy(int[][] source, int[][] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = Arrays.copyOf(source[i], source[i].length);
        }
    }

    private static void show(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                StdOut.print(a[i][j] + " ");
            }
            StdOut.println();
        }
    }


    public static void main(String[] args) {
        int[][] lights = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int[][] actions = new int[3][3];
        int[][] result = new int[3][3];
        LightsOutPuzzle lightsOutPuzzle = new LightsOutPuzzle(lights, actions, result);
        lightsOutPuzzle.action();

    }


}
