package lwh.PointOffer;


public class Problem7_RebuildBTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);

    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        return reBuildBTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode reBuildBTree(int[] pre, int left1, int right1, int[] in, int left2, int right2) {
        TreeNode root = new TreeNode(pre[left1]);

        int i = left2;
        while (root.val != in[i]) {
            i++;
        }

        int len1 = i - left2;
        int len2 = right2 - i;

        if (len1 > 0) {
            root.left = reBuildBTree(pre, left1 + 1, left1 + len1, in, left2, left2 + len1 - 1);
        } else {
            root.left = null;
        }

        if (len2 > 0) {
            root.right = reBuildBTree(pre, right1 - len2 + 1, right1, in, right2 - len2 + 1, right2);
        } else {
            root.right = null;
        }

        return root;
    }

}
