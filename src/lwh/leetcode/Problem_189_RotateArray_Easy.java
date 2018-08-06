package lwh.leetcode;

import java.util.Arrays;

public class Problem_189_RotateArray_Easy {

    public static void rotate_1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, temp.length);

        for(int i = 0; i < nums.length; i++){
            int index = (i + k) % nums.length;
            nums[index] = temp[i];
        }
    }

    public static void rotate_2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0 , k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        rotate_2(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
