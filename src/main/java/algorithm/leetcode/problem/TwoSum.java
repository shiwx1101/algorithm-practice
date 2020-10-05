package algorithm.leetcode.problem;

import java.util.HashMap;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 * 
 * 
 */
public class TwoSum{

    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> numMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if(numMap.containsKey(target-nums[i])&&numMap.get(target-nums[i])!=i){
                return new int[]{i,numMap.get(target-nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 1;

        int[] result = new TwoSum().twoSum(nums, target);

        System.out.println(result[0] +"   "+ result[1]);

    }

}