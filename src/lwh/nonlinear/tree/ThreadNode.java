package lwh.nonlinear.tree;

public class ThreadNode {

    protected int e;
    protected ThreadNode lchild, rchild;
    protected int ltag, rtag;

    public ThreadNode(int e) {
        this.e = e;
    }
}
