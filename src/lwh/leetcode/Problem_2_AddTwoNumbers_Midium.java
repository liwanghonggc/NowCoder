package lwh.leetcode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
 * 将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Problem_2_AddTwoNumbers_Midium {

    static class ListNode {

        public int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        int index = 0;
        int val = p1.val + p2.val;
        if (val >= 10) {
            val = val - 10;
            index = 1;
        }
        ListNode res = new ListNode(val);
        ListNode q = res;

        p1 = p1.next;
        p2 = p2.next;

        while (p1 != null && p2 != null) {
            val = p1.val + p2.val + index;
            if (val >= 10) {
                val = val - 10;
                index = 1;
            } else {
                index = 0;
            }
            ListNode node = new ListNode(val);
            q.next = node;
            q = node;

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            val = p1.val + index;
            if (val >= 10) {
                val = val - 10;
                index = 1;
            } else {
                index = 0;
            }
            ListNode node = new ListNode(val);
            q.next = node;
            q = node;
            p1 = p1.next;
        }

        while (p2 != null) {
            val = p2.val + index;
            if (val >= 10) {
                val = val - 10;
                index = 1;
            } else {
                index = 0;
            }
            ListNode node = new ListNode(val);
            q.next = node;
            q = node;
            p2 = p2.next;
        }

        if (index == 1) {
            ListNode node = new ListNode(1);
            q.next = node;
        }

        return res;
    }

    public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = preHead;
        int index = 0;

        while (p != null || q != null) {
            int val1 = (p == null) ? 0 : p.val;
            int val2 = (q == null) ? 0 : q.val;
            int sum = val1 + val2 + index;
            index = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (index > 0) {
            cur.next = new ListNode(index);
        }

        return preHead.next;
    }

}
