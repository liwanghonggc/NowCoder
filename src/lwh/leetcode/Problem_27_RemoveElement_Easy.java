package lwh.leetcode;

public class Problem_27_RemoveElement_Easy {

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 4));
    }
}
