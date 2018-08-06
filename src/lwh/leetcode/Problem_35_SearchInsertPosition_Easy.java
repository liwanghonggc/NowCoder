package lwh.leetcode;

public class Problem_35_SearchInsertPosition_Easy {

    public static int searchInsert(int[] nums, int target) {
        if(nums == null) return -1;
        if(nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left <= right){
            if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
            mid = (left + right) / 2;
        }

        if(nums[0] < target){
            return mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 4));
    }
}
