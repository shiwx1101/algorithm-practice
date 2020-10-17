/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.explore.completely;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author shiwenxiang
 * @version : FourSum.java, v0.1 2020/10/17 shiwenxiang Exp $$
 */
public class FourSum {

    /**
     * 复杂度 n^4
     *
     * @param a
     * @return
     */
    public int fourSum(int[] a) {
        if (a.length < 4) return -1;
        int count = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    for (int l = k + 1; l < length; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    //TODO应该要用Map
//    public int fourSumPro(int[] a) {
//        if (a.length < 4) return -1;
//        int count = 0;
//        int length = a.length;
//        List<Integer> integer = Arrays.stream(a).boxed().collect(Collectors.toList());
//        for (int i = 0; i < length; i++) {
//            for (int j = i + 1; j < length; j++) {
//                for (int k = j + 1; k < length; k++) {
//                    int temp = -(a[i] + a[j] + a[k]);
//                    if (integer.contains(temp) && integer.indexOf(temp) != i
//                            && integer.indexOf(temp) != j && integer.indexOf(temp) != k) {
//                        count++;
//                    }
//                }
//            }
//        }
//        return count;
//
//    }

}
