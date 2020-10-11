package lwh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public BTree() {
        root = null;
    }

    public BTree(Node root) {
        this.root = root;
    }

    public void preOrder() {
        System.out.print("[");
        preOrder(root);
        System.out.println("]");
    }

    //前序递归遍历
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.e + ",");
            preOrder(root.lchild);
            preOrder(root.rchild);
        }
    }

    //前序非递归遍历
    public void preOrderNonRecursive() {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        System.out.print("[");
        while (p != null || stack.size() > 0) {
            if (p != null) {//压入所有的左节点，压入前访问它。左节点压入完后pop访问右节点。像这样算法时思考规律性的东西在哪。不管哪个节点都要压所节点判断右节点。
                System.out.print(p.e + ",");
                stack.push(p);
                p = p.lchild;
            } else {//
                p = stack.pop();
                p = p.rchild;
            }
        }
        System.out.println("]");
    }

    public void InOrder() {
        System.out.print("[");
        InOrder(root);
        System.out.println("]");
    }

    //中序递归遍历
    private void InOrder(Node root) {
        if (root != null) {
            InOrder(root.lchild);
            System.out.print(root.e + ",");
            InOrder(root.rchild);
        }
    }

    //中序非递归遍历
    public void InOrderNonRecursive() {
        Node p = root;
        Stack<Node> s = new Stack<>();
        System.out.print("[");
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.lchild;
            } else {
                p = s.pop();
                System.out.print(p.e + ",");
                p = p.rchild;
            }
        }
        System.out.println("]");
    }

    public void postOrder() {
        System.out.print("[");
        postOrder(root);
        System.out.println("]");
    }

    //后序递归遍历
    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.lchild);
            postOrder(root.rchild);
            System.out.print(root.e + ",");
        }
    }

    //后序非递归遍历
    public void postOrderNoRecursive() {
        Stack<Node> s = new Stack<>();
        Node p = root, r = null;
        System.out.print("[");
        while (p != null || s.size() > 0) {
            if (p != null) {
                s.push(p);
                p = p.lchild;
            } else {
                p = s.peek();
                if (p.rchild != null && p.rchild != r) {
                    p = p.rchild;
                    s.push(p);
                    p = p.lchild;
                } else {
                    p = s.pop();
                    System.out.print(p.e + ",");
                    r = p;
                    p = null;
                }
            }
        }
        System.out.println("]");
    }

    //二叉树的层次遍历,从上到下,从左到右
    public void levelOrder1() {
        Queue<Node> q = new LinkedList<>();
        Node p = root;
        q.add(p);
        System.out.print("[");
        while (!q.isEmpty()) {
            p = q.poll();
            System.out.print(p.e + ",");
            if (p.lchild != null) {
                q.add(p.lchild);
            }
            if (p.rchild != null) {
                q.add(p.rchild);
            }
        }
        System.out.println("]");
    }

    //二叉树层次遍历,每行输出每层元素
    public void levelOrderByLevel() {
        Queue<Node> q = new LinkedList<>();
        Node p = root;
        q.add(p);
        Node last = root;
        Node nlast = null;
        while (!q.isEmpty()) {
            p = q.poll();
            System.out.print(p.e + " ");
            if (p.lchild != null) {
                q.add(p.lchild);
                nlast = p.lchild;
            }
            if (p.rchild != null) {
                q.add(p.rchild);
                nlast = p.rchild;
            }
            if (p == last) {
                System.out.println();
                last = nlast;
            }
        }
    }

    //二叉树的层次遍历,从上到下,从右到左
    public void levelOrder2() {
        Queue<Node> q = new LinkedList<>();
        Node p = root;
        q.add(p);
        System.out.print("[");
        while (!q.isEmpty()) {
            p = q.poll();
            System.out.print(p.e + ",");
            if (p.rchild != null) {
                q.add(p.rchild);
            }
            if (p.lchild != null) {
                q.add(p.lchild);
            }
        }
        System.out.println("]");
    }

    //二叉树层次遍历自下而上,自右到左
    public void levelOrder3() {
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        Node p;
        System.out.print("[");
        if (root != null) {
            q.add(root);
            while (!q.isEmpty()) {
                p = q.poll();
                s.push(p);
                if (p.lchild != null) {
                    q.add(p.lchild);
                }
                if (p.rchild != null) {
                    q.add(p.rchild);
                }
            }
            while (!s.isEmpty()) {
                p = s.pop();
                System.out.print(p.e + ",");
            }
        }
        System.out.println("]");
    }

    //递归求二叉树高度
    public static int height1(Node root) {
        if (root == null) {
            return 0;
        }
        int l = height1(root.lchild);
        int r = height1(root.rchild);
        return 1 > r ? l + 1 : r + 1;
    }

    //非递归求二叉树高度
    public int height2() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        q.add(root);
        int level = 0;
        while (q.size() > 0) {
            int len = q.size();
            level++;
            while (len-- > 0) {
                Node p = q.poll();
                if (p.lchild != null) {
                    q.add(p.lchild);
                }
                if (p.rchild != null) {
                    q.add(p.rchild);
                }
            }
        }
        return level;
    }

    //二叉树树各节点值互不相同,先序遍历和中序遍历序列分别存在两个数组A,B中,建立该二叉树
    public static Node preInCreateTree(int[] A, int[] B, int l1, int h1, int l2, int h2) {
        Node root = new Node(A[l1]);
        int i = 0;
        for (i = l2; B[i] != root.e; i++) ;
        int llen = i - l2;
        int rlen = h2 - i;
        if (llen > 0) {
            root.lchild = preInCreateTree(A, B, l1 + 1, l1 + llen, l2, l2 + llen - 1);
        } else {
            root.lchild = null;
        }
        if (rlen > 0) {
            root.rchild = preInCreateTree(A, B, h1 - rlen + 1, h1, h2 - rlen + 1, h2);
        } else {
            root.rchild = null;
        }
        return root;
    }

    //判断一颗二叉树是否是完全二叉树
    //采用层次遍历的方法,将所有节点加入队列(包括空节点),当遇到空节点时,判断其后有没有非空节点,若有则不是完全二叉树
    public boolean isCompleteBTree1() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return true;
        }
        q.add(root);
        while (q.size() > 0) {
            Node p = q.poll();
            if (p != null) {
                q.add(p.lchild);
                q.add(p.rchild);
            } else {
                while (q.size() > 0) {
                    p = q.poll();
                    if (p != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //若左子树为空右子树不为空直接false,若左右子树都为空置标志位flag为true,表明后面节点都为叶子节点
    //若左子树不为空且flag为true返回false,若左子树不为空,右子树为空置flag为true
    public boolean isCompleteBTree2() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return true;
        }
        q.add(root);
        Node p;
        boolean flag = false;
        while (q.size() > 0) {
            p = q.poll();
            if (p.lchild != null) {
                if (flag) {
                    return false;
                }
                q.add(p.lchild);
                if (p.rchild != null) {
                    q.add(p.rchild);
                } else {
                    flag = true;
                }
            } else {
                if (p.rchild != null) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }

    //统计二叉链表中双分支节点的个数
    public int countTwo1() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        q.add(root);
        int num = 0;
        Node p;
        while (q.size() > 0) {
            p = q.poll();
            if (p.lchild != null && p.rchild != null) {
                num++;
            }
            if (p.lchild != null) {
                q.add(p.lchild);
            }
            if (p.rchild != null) {
                q.add(p.rchild);
            }
        }
        return num;
    }

    //递归统计二叉链表中双分支节点个数
    public int countTwo2(Node p) {
        if (p == null) {
            return 0;
        } else if (p.lchild != null && p.rchild != null) {
            return countTwo2(p.lchild) + countTwo2(p.rchild) + 1;
        } else {
            return countTwo2(p.lchild) + countTwo2(p.rchild);
        }
    }

    //递归交换二叉树所有节点的左右子树
    public void change1(Node p) {
        if (p == null) {
            return;
        }
        Node temp = p.lchild;
        p.lchild = p.rchild;
        p.rchild = temp;
        change1(p.lchild);
        change1(p.rchild);
    }

    //非递归交换二叉树所有节点的左右子树
    public Node change2() {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return null;
        }
        q.add(root);
        Node p;
        while (q.size() > 0) {
            p = q.poll();
            Node temp = p.lchild;
            p.lchild = p.rchild;
            p.rchild = temp;
            if (p.lchild != null) {
                q.add(p.lchild);
            }
            if (p.rchild != null) {
                q.add(p.rchild);
            }
        }
        return root;
    }

    //非递归求先序遍历序列中第k个节点的值
    public void K_Node(int k) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<>();
        Node p = root;
        int num = 0;
        while (p != null || s.size() > 0) {
            if (p != null) {
                num++;
                if (num == k) {
                    System.out.println("第" + k + "个节点值为:" + p.e);
                    return;
                }
                s.push(p);
                p = p.lchild;
            } else {
                p = s.pop();
                p = p.rchild;
            }
        }
        System.out.println("K小于1或超出二叉树节点总数");
    }

    //对于树中每一个元素值为x的节点,删去以它为根的子树,并释放存储空间
    public void release(int x) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        q.add(root);
        Node p;
        while (q.size() > 0) {
            p = q.poll();
            if (p.e == x) {
                p.lchild = null;
                p.rchild = null;
            } else {
                if (p.lchild != null) {
                    q.add(p.lchild);
                    if (p.lchild.e == x)
                        p.lchild = null;
                }
                if (p.rchild != null) {
                    q.add(p.rchild);
                    if (p.rchild.e == x)
                        p.rchild = null;
                }
            }
        }
    }

    //查找所有值为x的节点的所有祖先
    //此处被下面findNearAncestor方法修改了,若要用原功能修改回即可
    public boolean findAncestor(Node p, int num, List list) {
        if (p == null) {
            return false;
        }
        if (p.e == num) {
            return true;
        }
        if (findAncestor(p.lchild, num, list) || findAncestor(p.rchild, num, list)) {
            //System.out.println(p.e);
            list.add(p);
            return true;
        }
        return false;
    }

    //查找p,q最近公共祖先
    public Node findNearAncestor(Node p, Node q) {
        List<Node> l1 = new ArrayList<>();
        List<Node> l2 = new ArrayList<>();
        findAncestor(root, p.e, l1);
        findAncestor(root, q.e, l2);
        Node result = null;
        int i = l1.size() - 1;
        int j = l2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (l1.get(i).equals(l2.get(j))) {
                result = l1.get(i);
            }
            i--;
            j--;
        }
        return result;
    }

    //求非空二叉树的宽度
    public int width() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node p;
        int temp = 0;
        int width = 0;
        ;
        while (q.size() > 0) {
            temp = q.size();
            if (temp > width) {
                width = temp;
            }
            while (temp-- > 0) {
                p = q.poll();
                if (p.lchild != null) {
                    q.add(p.lchild);
                }
                if (p.rchild != null) {
                    q.add(p.rchild);
                }
            }
        }
        return width;
    }

    //判断两个二叉树是否相似
    public boolean similar(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        if (similar(p.lchild, q.lchild) && similar(p.rchild, q.rchild)) {
            return true;
        }
        return false;
    }

    //将二叉树的叶节点按从左到右的顺序连成一个单链表,表头指针为head,带头节点
    public void linkLeafNode() {
        Node head = new Node();
        Node r = head;
        Stack<Node> s = new Stack<>();
        Node p = root;
        while (p != null || s.size() > 0) {
            if (p != null) {
                s.push(p);
                p = p.lchild;
            } else {
                p = s.pop();
                if (p.lchild == null && p.rchild == null) {
                    r.rchild = p;
                    r = p;
                }
                p = p.rchild;
            }
        }
        printLinkedList(head.rchild);
    }

    private void printLinkedList(Node p) {
        System.out.print("[");
        while (p != null) {
            System.out.print(p.e + ",");
            p = p.rchild;
        }
        System.out.println("]");
    }

    //将二叉树的叶节点按从左到右的顺序连成一个单链表,表头指针为head,带头节点
    //递归实现
    Node head = new Node();
    Node pre = head;

    public Node LinkLeafNode(Node p) {
        if (p != null) {
            LinkLeafNode(p.lchild);
            if (p.lchild == null && p.rchild == null) {
                pre.rchild = p;
                pre = p;
            }
            LinkLeafNode(p.rchild);
        }
        return head;
    }

    //测试LinkLeafNode(Node p)方法
    public void printLinkedList2() {
        Node head = LinkLeafNode(root);
        printLinkedList(head.rchild);
    }

    //有一颗满二叉树,已知先序序列pre求后序序列
    //满二叉树元素肯定是奇数(除空树)
    //递归输出,每次将先序序列分成第一个元素,左子树,右子树
    public void preGetPost(int[] a) {
        if (a.length > 3) {
            int[] b = new int[(a.length - 1) / 2];
            System.arraycopy(a, 1, b, 0, b.length);
            preGetPost(b);

            int[] c = new int[(a.length - 1) / 2];
            System.arraycopy(a, (a.length - 1) / 2 + 1, c, 0, c.length);
            preGetPost(c);

            System.out.print(a[0] + ",");
        } else {
            System.out.print(a[1] + "," + a[2] + "," + a[0] + ",");
        }
    }

    //求二叉树的带权路径长度WPL,每个叶节点的深度取权值之积的和
    //递归
    static int wpl = 0;

    public static int getWPL(Node p, int deep) {
        if (p.lchild == null && p.rchild == null) {
            wpl += deep * p.e;
        }
        if (p.lchild != null) {
            getWPL(p.lchild, deep + 1);
        }
        if (p.rchild != null) {
            getWPL(p.rchild, deep + 1);
        }
        return wpl;
    }

    //采用队列实现计算WPL
    public int getWPL() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int wpl = 0;
        int deep = 0;
        while (q.size() > 0) {
            int len = q.size();
            while (len-- > 0) {
                Node p = q.poll();
                if (p.lchild != null) {
                    q.add(p.lchild);
                }
                if (p.rchild != null) {
                    q.add(p.rchild);
                }
                if (p.lchild == null && p.rchild == null) {
                    wpl += deep * p.e;
                }
            }
            deep++;
        }
        return wpl;
    }

    //二叉排序树的递归查找
    public Node find(Node p, int x) {
        if (p != null) {
            if (x == p.e) {
                return p;
            } else if (x < p.e) {
                return find(p.lchild, x);
            } else {
                return find(p.rchild, x);
            }
        }
        return null;
    }

    //二叉排序树的非递归查找
    public Node find(int x) {
        Node p = root;
        while (p != null) {
            if (x == p.e) {
                return p;
            } else if (x < p.e) {
                p = p.lchild;
            } else {
                p = p.rchild;
            }
        }
        return null;
    }

    //二叉排序树的非递归插入,若存在就不插入
    public static Node insert(int x, BTree t) {
        Node node = new Node(x);
        if (t.root == null) {
            t.root = node;
            return node;
        }
        Node p = t.root;
        Node pre = null;
        int f = 0;
        while (p != null) {
            if (x == p.e) {
                return p;
            } else if (x < p.e) {
                if (p.lchild == null) {
                    pre = p;
                    f = 1;
                }
                p = p.lchild;

            } else {
                if (p.rchild == null) {
                    pre = p;
                    f = 2;
                }
                p = p.rchild;

            }
        }
        if (f == 1) {
            pre.lchild = node;
        } else {
            pre.rchild = node;
        }
        return node;
    }

    //二叉排序树的递归插入,若存在就不插入
    public Node insert(Node p, int x) {
        Node node = new Node(x);
        if (p == null) {
            root = node;
            return node;
        }
        if (p != null) {
            if (x == p.e) {
                System.out.println("节点已存在");
                return p;
            }
            if (x < p.e) {
                if (p.lchild == null) {
                    p.lchild = node;
                } else {
                    return insert(p.lchild, x);
                }
            } else {
                if (p.rchild == null) {
                    p.rchild = node;
                } else {
                    return insert(p.rchild, x);
                }
            }
        }
        return node;
    }

    //以数组建立一个二叉排序树
    public static BTree createBST(int[] a) {
        BTree t = new BTree();
        int i = 0;
        while (i < a.length) {
            insert(a[i], t);
            i++;
        }
        return t;
    }

    //二叉排序树的删除
    public boolean delete(int x) {
        Node p = root;
        Node pre = null;
        while (p != null) {
            if (x == p.e) {
                break;
            } else if (x < p.e) {
                pre = p;
                p = p.lchild;
            } else {
                pre = p;
                p = p.rchild;
            }
        }
        if (p == null) {
            System.out.println("要删除的节点不存在");
            return false;
        }
        if (p == root) {
            if (p.lchild == null && p.rchild == null) {
                root = null;
                return true;
            } else if (p.lchild != null && p.rchild != null) {
                Node q = p.rchild;
                pre = p;
                while (q.lchild != null) {
                    pre = q;
                    q = q.lchild;
                }
                pre.lchild = q.rchild;
                q.lchild = root.lchild;
                q.rchild = root.rchild;
                root = q;
                p.lchild = null;
                p.rchild = null;
                p = null;
                return true;
            } else {
                if (root.lchild != null) {
                    root = root.lchild;
                } else {
                    root = root.rchild;
                }
                return true;
            }
        }
        if (p.lchild == null && p.rchild == null) {
            if (pre.lchild == p) {
                pre.lchild = null;
                return true;
            }
            pre.rchild = null;
            return true;
        }
        if ((p.lchild == null && p.rchild != null) || (p.lchild != null && p.rchild == null)) {
            if (p.lchild != null) {
                pre.rchild = p.lchild;
                p = null;
                return true;
            }
            if (pre.lchild == p) {
                pre.lchild = p.rchild;
            }
            if (pre.rchild == p) {
                pre.rchild = p.rchild;
            }
            p = null;
            return true;
        }
        if (p.lchild != null && p.rchild != null) {
            Node q = p.rchild;
            Node r = p;
            while (q.lchild != null) {
                r = q;
                q = q.lchild;
            }
            if (pre.lchild == p) {
                pre.lchild = q;
            }
            if (pre.rchild == p) {
                pre.rchild = q;
            }
            if (r != p) {
                r.lchild = q.rchild;
                q.lchild = p.lchild;
                q.rchild = p.rchild;
            } else {
                q.lchild = p.lchild;
            }
            return true;
        }
        return false;
    }

    //判断二叉树是否是二叉排序树
    public boolean isBSTree(Node p) {
        if (p == null) {
            return true;
        }
        if (p.lchild != null && p.rchild == null) {
            if (p.lchild.e > p.e) {
                return false;
            } else {
                return isBSTree(p.lchild);
            }
        }
        if (p.rchild != null && p.lchild == null) {
            if (p.rchild.e < p.e) {
                return false;
            } else {
                return isBSTree(p.rchild);
            }
        }
        if (p.rchild != null && p.lchild != null) {
            if (p.lchild.e > p.e || p.rchild.e < p.e) {
                return false;
            }
            return isBSTree(p.lchild) && isBSTree(p.rchild);
        }
        return true;
    }

    //求指定节点在二叉排序树中的层次
    public int getLevel(int x) {
        int level = 1;
        Node p = root;
        while (p != null) {
            if (x == p.e) {
                return level;
            } else if (x < p.e) {
                level++;
                p = p.lchild;
            } else {
                level++;
                p = p.rchild;
            }
        }
        System.out.println("没找到该节点");
        return -1;
    }

    //判断是否是二叉平衡树
    public boolean isAVL(Node p) {
        if (p == null) {
            return true;
        }
        if (p.lchild != null && p.rchild == null) {
            if (height1(p.lchild) == 1) {
                return true;
            }
            return false;
        }
        if (p.lchild == null && p.rchild != null) {
            if (height1(p.rchild) == 1) {
                return true;
            }
            return false;
        }
        if (p.lchild != null && p.rchild != null) {
            int h = height1(p.lchild) - height1(p.rchild);
            if (Math.abs(h) > 1) {
                return false;
            }
            return isAVL(p.lchild) && isAVL(p.rchild);
        }
        return true;
    }

    //求二叉排序树中最小的关键字
    public int getMin() {
        Node p = root;
        while (p.lchild != null) {
            p = p.lchild;
        }
        return p.e;
    }

    //非递归从大到小输出二叉排序树中所有其值不小于K的关键字
    public void printBigK(int k) {
        Stack<Node> s = new Stack<>();
        Stack<Integer> s1 = new Stack<>();
        Node p = root;
        while (p != null || s.size() > 0) {
            if (p != null) {
                s.push(p);
                p = p.lchild;
            } else {
                p = s.pop();
                if (p.e >= k) {
                    s1.push(p.e);
                }
                p = p.rchild;
            }
        }
        while (s1.size() > 0) {
            System.out.print(s1.pop() + ",");
        }
        System.out.println();
    }

    //非递归从大到小输出二叉排序树中所有其值不小于K的关键字
    public void printBigK(Node p, int k) {
        if (p == null) {
            return;
        }
        if (p.rchild != null) {
            printBigK(p.rchild, k);
        }
        if (p.e >= k) {
            System.out.print(p.e + ",");
        }
        if (p.lchild != null) {
            printBigK(p.lchild, k);
        }
    }

    //判断一个数组元素是否是一颗二叉排序树的后序遍历序列
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null) {
            return false;
        }
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        int last = sequence.length - 1;
        int max = sequence[last];
        int temp1 = 0;
        while (sequence[temp1] < max && temp1 < last) {
            temp1++;
        }
        int temp2 = temp1;
        while (sequence[temp2] > max && temp2 < last) {
            temp2++;
        }
        if (temp2 == last)
            return true;
        else {
            return false;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(Node pRoot) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<Integer> inList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> outList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(pRoot);
        Node p = null;
        while (q.size() > 0) {
            int len = q.size();
            while (len-- > 0) {
                p = q.poll();
                inList.add(p.e);
                if (p.lchild != null) {
                    q.add(p.lchild);
                }
                if (p.rchild != null) {
                    q.add(p.rchild);
                }
            }
            outList.add(inList);
            inList = new ArrayList<>();
        }
        return outList;
    }

    //先序非递归遍历,根左右
    public static void preOrderNoRec(Node root) {
        System.out.print("先序遍历: ");
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.e + ", ");
                //有右孩子先加右孩子
                if (node.rchild != null) {
                    stack.push(node.rchild);
                }
                if (node.lchild != null) {
                    stack.push(node.lchild);
                }
            }
        }
        System.out.println();
    }

    //后序非递归遍历,左右根
    //已知先序非递归遍历,根左右,简易变换可得根右左,然后之前先序输出时不输出,而是加入辅助栈中,最后才从辅助栈中弹出,则为左右根
    public static void postOrderNoRec(Node root) {
        System.out.print("后序遍历: ");
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                help.push(node);
                if (node.lchild != null) {
                    stack.push(node.lchild);
                }
                if (node.rchild != null) {
                    stack.push(node.rchild);
                }
            }
            while (!help.isEmpty()) {
                System.out.print(help.pop().e + ", ");
            }
        }
    }

    //按之字形打印二叉树
    public ArrayList<ArrayList<Integer>> printTreeZig(Node root) {
        Queue<Node> q = new LinkedList<>();
        Node p = root;
        q.add(p);

        Node last = root;
        Node nlast = null;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            p = q.poll();
            list.add(p.e);

            if (p.lchild != null) {
                q.add(p.lchild);
                nlast = p.lchild;
            }
            if (p.rchild != null) {
                q.add(p.rchild);
                nlast = p.rchild;
            }
            if (p == last) {
                res.add(list);
                list = new ArrayList<>();
                last = nlast;
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                reverseList(res.get(i));
            }
        }
        return res;
    }

    public static void testReverse() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        reverseList(list);
        System.out.println(list);
    }

    private static void reverseList(ArrayList<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            int left = list.get(i);
            int right = list.get(len - i - 1);
            list.set(i, right);
            list.set(len - i - 1, left);
        }
    }

    //判断是不是平衡二叉树
    private static boolean isBalanced = true;

    public static boolean isBalanced_Solution(Node root) {
        getDepth(root);
        return isBalanced;
    }

    private static int getDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.lchild);
        int right = getDepth(root.rchild);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return right > left ? right + 1 : left + 1;
    }

    /**
     * 剑指offer34,二叉树中和为某一值的路径
     **/
    public void findPath(int k) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        findPathRecur(root, k, stack);
    }

    private void findPathRecur(Node p, int k, Stack<Integer> stack) {
        if (p == null) {
            return;
        }
        if (p.lchild == null && p.rchild == null) {
            if (p.e == k) {
                for (int i : stack) {
                    System.out.print(i + ", ");
                }
                System.out.println(p.e);
            }
        } else {
            stack.push(p.e);
            findPathRecur(p.lchild, k - p.e, stack);
            findPathRecur(p.rchild, k - p.e, stack);
            stack.pop();
        }
    }

}
