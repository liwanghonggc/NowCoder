package lwh.leetcode;

public class Problem_108_ConvertSortArrBBTree_Easy {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        return getBalanceBSTRecursive(nums, 0, nums.length - 1);
    }

    private static TreeNode getBalanceBSTRecursive(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getBalanceBSTRecursive(nums, left, mid - 1);
        root.right = getBalanceBSTRecursive(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {

    }
}
