package algorithm.leetcode.array;

public class RemoveDuplicatesfromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
            j++;

        }
        return i;

    }
}
