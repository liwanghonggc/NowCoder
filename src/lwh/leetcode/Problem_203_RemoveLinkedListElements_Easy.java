package lwh.leetcode;

public class Problem_203_RemoveLinkedListElements_Easy {

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode p = head;
        while(p != null && p.val == val){
            p = p.next;
        }
        if(p == null){
            return null;
        }
        preHead.next = p;

        ListNode q = p.next;
        while(q != null){
            if(q.val != val){
                p.next = q;
                p = q;
            }
            q = q.next;
        }
        p.next = q;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        removeElements(n1, 1);
    }
}
