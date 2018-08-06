package lwh.leetcode;

public class Problem_237_DeleteNodeInLinkedList_Easy {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
