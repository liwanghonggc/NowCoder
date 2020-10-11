package lwh.leetcode;

public class Problem_136_SingelNumber_Easy {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 2, 1};
        System.out.println(singleNumber(nums));
    }
}
