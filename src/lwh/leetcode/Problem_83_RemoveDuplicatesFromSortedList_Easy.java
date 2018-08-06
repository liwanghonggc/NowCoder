package lwh.leetcode;

public class Problem_83_RemoveDuplicatesFromSortedList_Easy {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode p = head, q = head.next;
        while(q != null){
            if(p.val != q.val){
                p.next = q;
                p = q;
            }
            q = q.next;
        }
        p.next = q;
        return head;
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
        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(1);
//
//        ListNode n4 = new ListNode(2);
//        ListNode n5 = new ListNode(3);
//
//        ListNode n6 = new ListNode(3);
        //ListNode n7 = new ListNode(4);

        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
        //n6.next = n7;

        ListNode res = deleteDuplicates(n1);
        printList(res);
    }
}
