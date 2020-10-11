package lwh.leetcode;

public class Problem_110_BalancedBinaryTree_Easy {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        return left > right ? left : right;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(16);
        TreeNode n6 = new TreeNode(17);
        TreeNode n7 = new TreeNode(18);

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n1.left = n2;
        //n1.right = n3;

        System.out.println(height(n1));
    }
}
