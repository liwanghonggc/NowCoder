package lwh.leetcode;

public class Problem_226_InvertBinaryTree_Easy {

    public static TreeNode invertTree(TreeNode root) {
        reverseRecursive(root);
        return root;
    }

    private static void reverseRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverseRecursive(root.left);
        reverseRecursive(root.right);
    }
}
