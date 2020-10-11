package lwh.leetcode;

public class Problem_26_RemoveDuplicatesFromSortedArray_Easy {

    public static int removeDuplicates_1(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;

        int i = 0;
        int count = 0;
        while (i < nums.length - 1 - count) {
            int j = 0;
            for (j = i + 1; j < nums.length - count; j++) {
                if (nums[j] == nums[i]) {
                    continue;
                } else {
                    break;
                }
            }
            if (j > i + 1) {
                System.arraycopy(nums, j, nums, i + 1, nums.length - j);
                count += j - i - 1;
            }
            i++;
        }

        return nums.length - count;
    }

    public static int removeDuplicates_2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3};
        System.out.println(removeDuplicates_2(nums));
    }
}
