package lwh.leetcode;

public class Problem_235_LowestCommonAncestorOfBinarySearchTree_Easy {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null) {
            return null;
        }
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        if (p.val == root.val && q.val > root.val) {
            return root;
        }
        if (q.val == root.val && p.val < root.val) {
            return root;
        }
        if (p.val < root.val && q.val > root.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

}
