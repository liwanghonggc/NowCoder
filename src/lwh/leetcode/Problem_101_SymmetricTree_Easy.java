package lwh.leetcode;

public class Problem_101_SymmetricTree_Easy {

    public boolean isSymmetric_1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRecursive(root.left, root.right);
    }

    public boolean isSymmetricRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) {
            return false;
        }
        return isSymmetricRecursive(p.left, q.right) && isSymmetricRecursive(p.right, q.left);
    }

    public static void main(String[] args) {

    }
}
