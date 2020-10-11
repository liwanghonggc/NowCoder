package lwh.linearlist.linklist;

import java.util.Scanner;

//带头节点的单链表
public class LinkedList {

    private Node head;

    public LinkedList() {
        Node node = new Node();
        node.next = null;
        head = node;
    }

    //头插法建立单链表
    public void createListHead() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num != 99) {
                Node node = new Node(num);
                node.next = head.next;
                head.next = node;
            } else {
                break;
            }
        }
    }

    //尾插法建立单链表
    public void createListTail() {
        //设立尾指针一直指向表尾节点
        Node tail = head;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num != 99) {
                Node node = new Node(num);
                tail.next = node;
                tail = node;
            } else {
                break;
            }
        }
    }

    //求表长
    public int length() {
        Node p = head.next;
        int i = 0;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    //查找第i个节点值,并返回指向该节点的指针
    public Node findIndex(int i) {
        if (i == 0) {
            return head;
        }
        if (i < 0) {
            return null;
        }
        int j = 1;
        Node p = head.next;
        while (p != null && j < i) {
            p = p.next;
            j++;
        }
        return p;
    }

    //按值查找表节点
    public Node findValue(int x) {
        Node p = head.next;
        while (p != null && p.e != x) {
            p = p.next;
        }
        return p;
    }

    //在i处插入节点,0表示头结点,若i超过链表长度则插在最后
    public boolean insert(int i, int x) {
        if (i < 1) {
            System.out.println("Insert index illeagal");
            return false;
        }
        Node p = head.next;
        Node q = p;
        int j = 1;
        while (p != null && j < i) {
            q = p;
            p = p.next;
            j++;
        }
        Node node = new Node(x);
        node.next = q.next;
        q.next = node;
        return true;
    }

    //删除第i个节点
    public boolean delete(int i) {
        if (i < 1) {
            System.out.println("Delete index illegal");
            return false;
        }
        if (i > length()) {
            System.out.println("Delete index illegal");
            return false;
        }
        Node p = head.next;
        Node q = head;
        int j = 1;
        while (p != null && j < i) {
            q = p;
            p = p.next;
            j++;
        }
        q.next = p.next;
        p.next = null;
        return true;
    }


    //带头节点的单链表中删除所有值为x的节点
    public void deleteAllx1(int x) {
        Node p = head.next;
        Node q = head;
        while (p != null) {
            while (p != null && p.e != x) {
                q = p;
                p = p.next;
            }
            if (p != null) {
                q.next = p.next;
                p.next = null;
                p = null;
                p = q.next;
            } else {
                q.next = null;
            }
        }
    }

    //带头节点的单链表中删除所有值为x的节点
    public void deleteAllx2(int x) {
        Node p = head;
        Node q = head.next;
        while (q != null) {
            if (q.e == x) {
                p.next = q.next;
                q = q.next;
            } else {
                p = q;
                q = q.next;
            }
        }
    }

    //带头节点的单链表中删除所有值为x的节点,使用尾插法
    public void deleteAllx3(int x) {
        Node r = head, p = head.next, q;
        while (p != null) {
            if (p.e != x) {//将其插入到单链表后面
                r.next = p;
                r = p;
                p = p.next;
            } else {//删除节点
                q = p;
                p = p.next;
                q = null;
            }
        }
        r.next = null;
    }

    //逆序输出带头节点的单链表所有的值,也可以用栈实现
    public void reversePrint1() {
        if (head.next == null) {
            System.out.println("No num");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Node node = head.next;
        while (node != null) {
            sb.append(node.e);
            node = node.next;
        }
        System.out.println(sb.reverse().toString());
    }

    public void reversePrint2() {
        reversePrint2(head.next);
        System.out.println();
    }

    //逆序输出带头节点的单链表所有的值
    private void reversePrint2(Node node) {
        if (node.next != null) {
            reversePrint2(node.next);
        }
        System.out.print(node.e);
    }

    //删除带头节点的单链表中最小值的节点,假设唯一
    public boolean deleteMin() {
        if (head.next == null) {
            System.out.println("No num");
            return false;
        }
        Node q = head, p = head.next, r = head.next;
        while (p.next != null) {
            if (p.next.e < r.e) {
                r = p.next;
                q = p;
            }
            p = p.next;
        }
        q.next = r.next;
        r.next = null;
        r = null;
        return true;
    }

    //就地逆置单链表,空间复杂度为O(1)
    public boolean reverse() {
        if (length() < 2) {
            System.out.println("No need to reverse");
            return false;
        }
        Node p = head.next;
        Node q = p.next;
        boolean flag = true;
        while (q != null) {
            Node r = q.next;
            if (flag) {
                p.next = null;
                flag = false;
            }
            head.next = q;
            q.next = p;
            p = q;
            q = r;
        }
        return true;
    }

    //使带头节点的单链表递增有序,插入排序
    public boolean sort() {
        if (length() < 2) {
            System.out.println("No need to sort");
            return false;
        }
        Node q = head.next.next;
        Node r = q.next;
        head.next.next = null;
        while (q != null) {
            Node pre = head;
            Node p = head.next;
            while (p != null && q.e > p.e) {
                pre = p;
                p = p.next;
            }
            pre.next = q;
            q.next = p;
            q = r;
            if (r != null)
                r = r.next;
        }
        return true;
    }

    //带表头节点的单链表元素值无序,删除所有在给定区间范围内的所有元素
    public boolean deleteInterval(int a, int b) {
        if (a > b) {
            System.out.println("Input a <= b");
            return false;
        }
        Node p = head;
        Node q = head.next;
        while (q != null) {
            if (q.e >= a && q.e <= b) {
                p.next = q.next;
                q.next = null;
                q = p.next;
            } else {
                p = q;
                q = q.next;
            }
        }
        return true;
    }

    //带头节点单链表，递增输出节点值并释放节点空间
    public void sortPrint() {
        while (head.next != null) {
            Node pre = head;
            Node p = pre.next, r = pre.next;
            while (p.next != null) {
                if (p.next.e < r.e) {
                    pre = p;
                    r = p.next;
                }
                p = p.next;
            }
            System.out.print(r.e + ",");
            pre.next = r.next;
            r.next = null;
            r = null;
        }
    }

    //将带头节点的单链表拆分成两个链表,奇数序号在一个,偶数序号在另一个,按原来相对顺序放置
    public void breakIntoTwo1() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        Node p = head.next;
        Node q = list1.head;
        Node r = list2.head;
        int i = 1;
        while (p != null) {
            if (i % 2 == 0) {
                r.next = p;
                r = p;
            } else {
                q.next = p;
                q = p;
            }
            i++;
            p = p.next;
        }
        q.next = null;
        r.next = null;
        list1.print();
        list2.print();
    }

    //将带头节点的单链表拆分成两个链表,奇数序号在一个,偶数序号在另一个,偶数序号的逆序放置
    public void breakIntoTwo2() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        Node p = head.next;
        Node q = list1.head;
        Node r = list2.head;
        int i = 1;
        while (p != null) {
            Node pre = p.next;
            if (i % 2 == 0) {
                p.next = r.next;
                r.next = p;
            } else {
                q.next = p;
                q = p;
            }
            i++;
            p = pre;
        }
        q.next = null;
        list1.print();
        list2.print();
    }

    //带头节点的单链表中元素递增有序,有重复元素,去重,使重复元素只含一个
    public void deleteDuplicate() {
        Node p = head.next;
        Node q = p.next;
        while (q != null) {
            if (p.e == q.e) {
                q = q.next;
            } else {
                p.next = q;
                p = q;
                q = q.next;
            }
        }
        p.next = null;
    }

    //两个带头节点的单链表递增,合并两个单链表使其递减,利用原来单链表的节点
    public void mergeSort(LinkedList list2) {
        Node p = this.head.next;
        Node q = list2.head.next;
        LinkedList newlist = new LinkedList();
        Node r = newlist.head;
        Node after = null;
        while (p != null && q != null) {
            if (p.e < q.e) {
                after = p.next;
                p.next = r.next;
                r.next = p;
                p = after;
            } else {
                after = q.next;
                q.next = r.next;
                r.next = q;
                q = after;
            }
            if (q == null) {
                while (p != null) {
                    after = p.next;
                    p.next = r.next;
                    r.next = p;
                    p = after;
                }
            }
            if (p == null) {
                while (q != null) {
                    after = q.next;
                    q.next = r.next;
                    r.next = q;
                    q = after;
                }
            }
        }
        newlist.print();
    }

    //两个带头节点的单链表递增有序,求两个链表的交集并存放于其中一个表,时间复杂度O(len1*len2)
    public void intersect1(LinkedList list2) {
        Node pre = this.head, p = pre.next;
        while (p != null) {
            Node q = list2.head.next;
            boolean flag = false;
            while (q != null) {
                if (q.e == p.e) {
                    flag = true;
                    break;
                }
                q = q.next;
            }
            if (flag) {
                pre = p;
                p = p.next;
            } else {
                pre.next = p.next;
                p.next = null;
                p = pre.next;
            }
        }
    }

    //两个带头节点的单链表递增有序,求两个链表的交集并存放于其中一个表,时间复杂度O(len1+len2)
    public void intersect2(LinkedList list2) {
        Node pre = this.head, p = pre.next;
        Node q = list2.head.next;
        while (p != null && q != null) {
            if (p.e == q.e) {
                pre.next = p;
                pre = p;
                p = p.next;
                q = q.next;
            } else if (p.e < q.e) {
                p = p.next;
            } else {
                q = q.next;
            }
        }
        pre.next = null;
    }

    //A,B两个带头节点的 单链表递增有序,求AB公共元素构成有序单链表C
    public LinkedList intersectC(LinkedList list2) {
        LinkedList newList = new LinkedList();
        Node r = newList.head;
        Node p = this.head.next;
        Node q = list2.head.next;
        while (p != null && q != null) {
            if (p.e == q.e) {
                Node node = new Node(p.e);
                r.next = node;
                r = node;
                p = p.next;
                q = q.next;
            } else if (p.e < q.e) {
                p = p.next;
            } else {
                q = q.next;
            }
        }
        return newList;
    }

    //两个整数序列构成两个带头节点的单链表A,B,判断B是否是A的连续子序列
    public boolean AisContainsB1(LinkedList list2) {
        if (this.length() < list2.length()) {
            return false;
        }
        Node p = this.head.next;
        Node q = list2.head.next;
        boolean flag = true;
        while (p != null && q != null) {
            if (p.e != q.e) {
                if (flag) {
                    p = p.next;
                }
                q = list2.head.next;
                continue;
            }
            p = p.next;
            q = q.next;
            if (q == null) {
                return true;
            }
            flag = false;
        }
        return false;
    }

    //两个整数序列构成两个带头节点的单链表A,B,判断B是否是A的连续子序列
    public boolean AisContainsB2(LinkedList list2) {
        if (this.length() < list2.length()) {
            return false;
        }
        Node p = this.head.next, pre = p;
        Node q = list2.head.next;
        while (p != null && q != null) {
            if (p.e == q.e) {
                p = p.next;
                q = q.next;
            } else {
                pre = pre.next;
                p = pre;
                q = list2.head.next;
            }
        }
        if (q == null) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        if (head.next == null) {
            System.out.println("No num");
            return;
        }
        System.out.print("[");
        for (Node node = head.next; node != null; node = node.next) {
            if (node.next != null)
                System.out.print(node.e + ",");
            else
                System.out.print(node.e + "]");
        }
        System.out.println();
    }
}
