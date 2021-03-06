package lwh.tree;

public class Node {

    public int e;
    public Node lchild;
    public Node rchild;

    public Node() {
    }

    public Node(int e) {
        this.e = e;
    }

    public Node(int e, Node lchild, Node rchild) {
        super();
        this.e = e;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public Node(Node lchild, Node rchild) {
        super();
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

}
