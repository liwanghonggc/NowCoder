package lwh.leetcode;

import java.util.Arrays;

public class Problem_268_MissingNumber_Easy {

    public static int missingNumber_1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int[] a = new int[nums.length + 1];

        Arrays.fill(a, -1);
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = nums[i];
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != i) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber_2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int len = nums.length;
        int expectedSum = len * (len + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < len; i++) {
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }

    public static int missingNumber_3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= (i ^ nums[i]);
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(missingNumber_3(nums));
    }
}
