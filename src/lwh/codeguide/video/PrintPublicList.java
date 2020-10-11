package lwh.codeguide.video;


import lwh.linklist.Node;

public class PrintPublicList {

    public void print(Node head1, Node head2) {
        int len1 = length(head1);
        int len2 = length(head2);
        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff > 0) {
                head1 = head1.next;
                diff--;
            }
        }
        if (len2 > len1) {
            int diff = len2 - len1;
            while (diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }
        while (head1 != null && head2 != null) {
            if (head1 != head2) {
                head1 = head1.next;
                head2 = head2.next;
            } else {
                break;
            }
        }
        while (head1 != null) {
            System.out.print(head1.e + ",");
        }
        System.out.println();
    }

    public int length(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
