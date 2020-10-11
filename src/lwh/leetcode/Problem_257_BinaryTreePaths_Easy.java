package lwh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem_257_BinaryTreePaths_Easy {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(rst, sb, root);
        return rst;
    }

    private void preOrderTraverse(List<String> rst, StringBuilder sb, TreeNode root) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            rst.add(sb.toString());
            return;
        }
        sb.append(root.val + "->");
        if (root.left != null) preOrderTraverse(rst, sb, root.left);
        if (root.right != null) preOrderTraverse(rst, sb, root.right);
    }
}
