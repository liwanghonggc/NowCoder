package lwh.PointOffer;

import lwh.tree.Node;

import java.util.Stack;

public class Problem34_BTreePathSum {

    /** 见BTree的findPath() **/

    public static void main(String[] args) {

    }

    private static void printPathSum(Node root, int k){
        Node p = root;
        if(p == null){
            return;
        }
        Stack<Integer> stack = new Stack<>();
        
        printPathRecur(p, stack, k);
    }

    private static void printPathRecur(Node p, Stack<Integer> stack, int k) {
        if(p == null){
            return;
        }
        if(p.lchild == null && p.rchild == null){
            if(p.e == k){
                for(int i : stack){
                    System.out.print(i + ", ");
                }
                System.out.println(p.e);
            }
        }else{
            stack.push(p.e);
            printPathRecur(p.lchild, stack, k - p.e);
            printPathRecur(p.rchild, stack, k - p.e);
            stack.pop();
        }
    }
}
