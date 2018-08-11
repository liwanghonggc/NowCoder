package lwh.tree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return preInCreateTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
    
    public static TreeNode preInCreateTree(int[] pre, int[] in, int left1, int right1, int left2, int right2){
        TreeNode root = new TreeNode(pre[left1]);
        int i = 0;
        for(i = left2; in[i] != root.val; i++);
        int llen = i - left2;
        int rlen = right2 - i;
        if(llen > 0){
            root.left = preInCreateTree(pre, in, left1+1, left1+llen, left2, left2+llen-1);
        }else{
            root.left = null;
        }
        if(rlen > 0){
            root.right = preInCreateTree(pre, in, right1-rlen+1, right1, right2-rlen+1, right2);
        }else{
            root.right = null;
        }
        return root;
    }
    
    public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		
		TreeNode root = reConstructBinaryTree(pre, in);
		System.out.println(root.val);
	}
}
