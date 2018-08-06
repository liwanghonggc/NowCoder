package lwh.leetcode;

import java.util.List;

public class Problem_234_PalindromeLinkedList_Easy {

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        slow = reverseRecursive(slow);
        fast = head;

        //注意要用slow,若用fast当链表为1时会发生空指针异常
        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private static ListNode reverseRecursive(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {

    }
}
