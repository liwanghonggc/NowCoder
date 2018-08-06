package lwh.leetcode;

public class Problem_206_ReverseLinkedList_Easy {

    //递归方式逆置单链表
    public static ListNode reverseList_1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList_1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //迭代,非递归方式反转单链表
    public static ListNode reverseList_2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null, p = head, q = head.next;
        while(q != null){
            p.next = pre;
            pre = p;
            p = q;
            q = q.next;
        }
        p.next = pre;
        return p;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printList(n1);

        ListNode newHead = reverseList_1(n1);
        printList(newHead);
    }

    public static void printList(ListNode head){
        System.out.print("[");
        for(ListNode p = head; p != null; p = p.next){
            System.out.print(p.val + ", ");
        }
        System.out.println("]");
    }
}
