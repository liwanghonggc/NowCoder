package lwh.leetcode;

public class Problem_112_PathSumInBST_Easy {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        int diff = sum - root.val;
        if(root.left == null && root.right == null){
            return diff == 0;
        }

        return hasPathSum(root.left, diff) || hasPathSum(root.right, diff);
    }
}
