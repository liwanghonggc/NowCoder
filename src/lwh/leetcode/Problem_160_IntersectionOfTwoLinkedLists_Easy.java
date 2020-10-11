package lwh.leetcode;
/**
 *
 */
public class Problem_160_IntersectionOfTwoLinkedLists_Easy {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = length(headA);
        int len2 = length(headB);
        int diff = len2 - len1;
        if (diff > 0) {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        } else {
            while (diff < 0) {
                headA = headA.next;
                diff++;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
