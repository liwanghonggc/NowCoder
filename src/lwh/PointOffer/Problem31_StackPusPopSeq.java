package lwh.PointOffer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class Problem31_StackPusPopSeq {

    public static void main(String[] args) {
        int[] seq1 = {1, 2, 3, 4, 5};
        int[] seq2 = {4, 5, 3, 2, 1};
        int[] seq3 = {4, 3, 5, 1, 2};

        System.out.println(isPushPopOrder(seq1, seq2));
        System.out.println(isPushPopOrder(seq1, seq3));
    }

    private static boolean isPushPopOrder(int[] seq1, int[] seq2) {
        if (seq1 == null || seq2 == null || seq1.length != seq2.length) {
            return false;
        }

        boolean result = true;
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        stack.push(seq1[index++]);

        for (int i = 0; i < seq2.length; ) {
            if (seq2[i] == stack.peek()) {
                i++;
                stack.pop();
            } else {
                if (index < seq1.length) {
                    stack.push(seq1[index++]);
                } else {
                    return false;
                }
            }
        }

        return result;
    }
}
