package algorithm.leetcode.array;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

            }
//            for (int j = i + 1; j < n; j++) {
//                int k = indexOf(nums, -nums[i] - nums[j]);
//                if (k > j) {
//                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                }
//            }
        }
        return res;
    }

    int indexOf(int[] source, int target) {
        int head = 0;
        int tail = source.length - 1;
        while (tail >= head) {
            int mid = (head + tail) / 2;
            if (source[mid] > target) {
                tail = mid - 1;
            } else if (source[mid] < target) {
                head = mid + 1;
            } else {
                while (mid + 1 < source.length - 1 && source[mid + 1] == target) {
                    mid++;
                }
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        StdOut.print(new ThreeSum_15().threeSum(nums));
    }
}
