package lwh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_80_SameTree_Easy {

    public static boolean isSameTree_1(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if((p != null && q == null) || (p == null && q != null)){
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            p = q1.poll();
            q = q2.poll();

            if(p.val != q.val){
                return false;
            }

            if(p.left != null && q.left != null){
                if(p.left.val != q.left.val){
                    return false;
                }
                q1.add(p.left);
                q2.add(q.left);
            }
            if((p.left != null && q.left == null) || (p.left == null && q.left != null)){
                return false;
            }

            if(p.right != null && q.right != null){
                if(p.right.val != q.right.val){
                    return false;
                }
                q1.add(p.right);
                q2.add(q.right);
            }
            if((p.right != null && q.right == null) || (p.right == null && q.right != null)){
                return false;
            }
        }
        return true;
    }

    public static boolean isSameTree_2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null) || p.val != q.val) {
            return false;
        }
        return isSameTree_2(p.left, q.left) && isSameTree_2(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        //TreeNode n3 = new TreeNode(4);
        n1.right = n2;
        //n1.right = n3;

        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        //TreeNode n6 = new TreeNode(4);
        n4.left = n5;
        //n4.right = n6;

        System.out.println(isSameTree_2(n1, n4));
    }
}
