package algorithm.leetcode.array;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1;
                int hi = length - 1;
                while (hi > lo) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum > target) {
                        while (hi > lo && nums[hi] == nums[hi - 1]) hi--;
                        hi--;
                    } else if (sum < target) {
                        while (hi > lo && nums[lo + 1] == nums[lo]) lo++;
                        lo++;
                    } else {
                        return sum;
                    }
                    if (Math.abs(target - sum) < Math.abs(target - result)) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int i = new ThreeSumClosest_16().threeSumClosest(nums, 1);
        System.out.println(i);
    }
}
