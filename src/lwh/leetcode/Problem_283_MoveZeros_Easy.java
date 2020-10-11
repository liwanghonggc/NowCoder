package lwh.leetcode;

import java.util.Arrays;

public class Problem_283_MoveZeros_Easy {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        Arrays.fill(nums, index, nums.length, 0);
    }

    public static void main(String[] args) {
        int[] nums = {1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
