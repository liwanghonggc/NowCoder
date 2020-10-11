package lwh.nonlinear.tree;

public class ThreadTree {

    private ThreadNode root;

    public ThreadTree() {
        root = null;
    }

    public ThreadTree(ThreadNode root) {
        this.root = root;
    }

    //通过中序遍历建立线索二叉树主过程
    public void createInThread() {
        ThreadNode p = root;
        ThreadNode pre = null;
        if (p != null) {
            InThread(p, pre);
            pre.rchild = null;
            pre.rtag = 1;
        }
    }

    //通过中序遍历对二叉树线索化的递归算法
    private void InThread(ThreadNode p, ThreadNode pre) {
        if (p != null) {
            InThread(p.lchild, pre);
            if (p.lchild == null) {
                p.lchild = pre;
                p.ltag = 1;
            }
            if (pre != null && pre.rchild == null) {
                pre.rchild = p;
                pre.rtag = 1;
            }
            pre = p;
            InThread(p.rchild, pre);
        }
    }
}
