package lwh.linklist;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

//不带头节点的单链表
public class LinkList {

    private Node head;

    public LinkList() {
        head = null;
    }

    //判断一个单链表是否是回文结构
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        Node p = head;
        while (p != null) {
            stack.push(p.e);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (p.e != stack.pop()) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    //将单链表按照某值划分成左边小,中间相等,右边大的形式
    public void smallEqualBig(int k) {
        if (head == null || head.next == null) {
            return;
        }
        Node[] array = new Node[length()];
        Node p = head;
        int i = 0;
        while (p != null) {
            array[i++] = p;
            p = p.next;
        }

        //快排的partition
        int left = -1;
        int right = array.length;
        i = 0;
        while (i < right) {
            if (array[i].e < k) {
                swap(array, i++, ++left);
            } else if (array[i].e == k) {
                i++;
            } else {
                swap(array, i, --right);
            }
        }


        //重建单链表
        head = array[0];
        for (i = 1; i < array.length; i++) {
            array[i - 1].next = array[i];
        }
        array[i - 1].next = null;

    }

    private static void swap(Node[] a, int i, int j) {
        Node temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //判断单链表有无环,有返回入口节点,否则返回null
    public static Node isHaveCircle1(Node head) {
        Node p = head;
        Set<Node> set = new HashSet<>();
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }

    public static Node isHaveCircle2(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    //头插法建立单链表
    public void createListHead() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num != 99) {
                Node node = new Node(num);
                node.next = head;
                head = node;
            } else {
                break;
            }
        }
    }

    //递归删除不带头节点单链表中所有值为x的节点
    public void delete(int x) {
        Node q = head;
        Node p = q;
        while (q != null && x != q.e) {
            p = q;
            q = q.next;
        }
        if (q == head) {
            head = q.next;
            q.next = null;
            q = null;
            delete(x);
        } else if (q != null) {
            p.next = q.next;
            q.next = null;
            q = null;
            delete(x);
        } else {
            return;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("No num");
            return;
        }
        System.out.print("[");
        for (Node node = head; node != null; node = node.next) {
            if (node.next != null)
                System.out.print(node.e + ",");
            else
                System.out.print(node.e + "]");
        }
        System.out.println();
    }

    public int length() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    //删除单链表倒数第K个节点
    public void deleteNode1(int k) {
        int length = length();
        int len = length - k;
        if (k <= 0 || len < 0) {
            throw new RuntimeException("k值不合法");
        }
        if (len == 0) {
            head = head.next;
            return;
        }
        Node p = null;
        Node q = head;
        while (len > 0 && q != null) {
            p = q;
            q = q.next;
            len--;
        }
        p.next = q.next;
        q.next = null;
        q = null;
    }

    public void deleteNode2(int k) {
        if (head == null || k < 1) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
    }

    //删除链表中间节点
    public void deleteMiddleNode() {
        if (head == null) {
            return;
        }
        double len = length();
        if (len == 1) {
            head = null;
            return;
        }
        if (len == 2) {
            head = head.next;
            return;
        }

        int k = (int) Math.ceil(len / 2);
        Node p = null;
        Node q = head;
        int i = 0;
        while (++i < k) {
            p = q;
            q = q.next;
        }
        p.next = q.next;
    }

    //反转单链表,函数返回反转之后的头节点
    public Node reverse1() {
        if (head == null || head.next == null) {
            return head;
        }
        Node p = head, q = p.next, r = q.next;
        p.next = null;
        while (q != null) {
            q.next = p;
            p = q;
            q = r;
            if (r != null) {
                r = r.next;
            }
        }
        return p;
    }

    public Node reverse2() {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public Node reverse3() {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node p = head, q = head.next;
        while (p != null) {
            p.next = pre;
            pre = p;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        head = pre;
        return head;
    }

    //反转部分单链表
    public Node reversePart(int from, int to) {
        int len = length();
        if (from < 1 || to > len) {
            return head;
        }

        Node p = head, pre = null, q = head;
        int count = 1;
        while (count++ < from) {
            pre = p;
            p = p.next;
        }
        count = 1;
        while (count++ < to) {
            q = q.next;
        }
        Node qnext = q.next;

        Node p1 = p, next = null, p2 = null;
        while (p != qnext) {
            next = p.next;
            p.next = p2;
            p2 = p;
            p = next;
        }
        p1.next = qnext;
        if (pre != null) {
            pre.next = q;
            return head;
        }
        return q;
    }

    public void print(Node p) {
        if (p == null) {
            System.out.println("No num");
            return;
        }
        System.out.print("[");
        for (Node node = p; node != null; node = node.next) {
            if (node.next != null)
                System.out.print(node.e + ",");
            else
                System.out.print(node.e + "]");
        }
        System.out.println();
    }
}
