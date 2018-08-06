package lwh.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_107_BinaryTreeLevelOrderTraversal2_Easy {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> list = new ArrayList<>();
        TreeNode last = root, nlast = null;

        while(!q.isEmpty()){
            TreeNode p = q.poll();
            list.add(p.val);

            if(p.left != null){
                q.add(p.left);
                nlast = p.left;
            }
            if(p.right != null){
                q.add(p.right);
                nlast = p.right;
            }
            if(p == last){
                res.add(list);
                last = nlast;
                list = new ArrayList<>();
            }
        }

        int len = res.size();
        for(int i = 0; i < len / 2; i++){
            List<Integer> left = res.get(i);
            List<Integer> right = res.get(len-i-1);
            res.set(i, right);
            res.set(len-i-1, left);
        }
        return res;
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
        n1.right = n3;

        List<List<Integer>> res = levelOrderBottom(n1);
        System.out.println(res.toString());
    }

}
