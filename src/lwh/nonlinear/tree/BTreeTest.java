package lwh.nonlinear.tree;

public class BTreeTest {

    public static void main(String[] args) {
//		Node n10 = new Node(10, null, null);
//		Node n9 = new Node(9, null, null);
//		Node n8 = new Node(8, null, null);
//		Node n7 = new Node(7, n8, n9);
//		Node n6 = new Node(6, null, null);
//		Node n5 = new Node(5, null, null);
//		Node n4 = new Node(4, n6, null);
//		Node n3 = new Node(3, n10, n5);
//		Node n2 = new Node(2, n7, n4);
//		Node n1 = new Node(1, n2, n3);
//		BTree t1 = new BTree(n1);


        int[] a = {2, 3, 1, 4, 7, 5, 6};
        BTree t = BTree.buildTree(a);

        t.InOrder();
        t.preOrder();
        t.postOrder();

        BTree.morisIn(t.getRoot());
        BTree.morisPre(t.getRoot());
    }

}
