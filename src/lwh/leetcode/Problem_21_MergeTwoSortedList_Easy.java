package lwh.leetcode;

public class Problem_21_MergeTwoSortedList_Easy {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){ return null;}
        if(l1 == null){ return l2;}
        if(l2 == null){ return l1;}

        ListNode dumpyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dumpyHead;

        while (p != null && q != null){
            int val = p.val <= q.val ? p.val : q.val;
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = node;
            if(p.val <= q.val){
                p = p.next;
            }else {
                q = q.next;
            }
        }


        cur.next = (p != null) ? p : q;

        return dumpyHead.next;
    }

    public static void printList(ListNode head){
        System.out.print("[");
        for(ListNode p = head; p != null; p = p.next){
            System.out.print(p.val + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        n5.next = n6;
        n6.next = n7;

        ListNode res = mergeTwoLists(n1, n5);
        printList(res);
    }
}
