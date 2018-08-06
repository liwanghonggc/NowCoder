package lwh.leetcode;

public class Problem_198_HouseRobber_Easy {

    public static int rob(int[] nums) {
       if(nums == null || nums.length == 0){
           return 0;
       }
       if(nums.length == 1){
           return nums[0];
       }
       if(nums.length == 2){
           return Math.max(nums[0], nums[1]);
       }

       int len = nums.length;
       int[] sum = new int[len];
       sum[0] = nums[0];
       sum[1] = Math.max(nums[0], nums[1]);

       for(int i = 2; i < nums.length; i++){
           sum[i] = Math.max(sum[i-1], sum[i-2] + nums[i]);
       }

       return sum[len-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
