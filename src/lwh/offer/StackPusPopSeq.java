package lwh.offer;

import java.util.Stack;

/**
 * @author lwh
 * @date 2018-09-18
 * @desp 栈的压入弹出序列
 */
public class StackPusPopSeq {

    public static void main(String[] args) {
        int[] seq1 = {1, 2, 3, 4, 5};
        int[] seq2 = {4, 5, 3, 2, 1};
        int[] seq3 = {4, 3, 5, 1, 2};

        System.out.println(isPushPopSeq(seq1, seq2));
        System.out.println(isPushPopSeq(seq1, seq3));
    }

    private static boolean isPushPopSeq(int[] seq1, int[] seq2) {
        if (seq1 == null || seq2 == null || seq1.length != seq2.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(seq1[index++]);

        for (int i = 0; i < seq2.length; ) {
            if (seq2[i] == stack.peek()) {
                stack.pop();
                i++;
            } else {
                if (index < seq1.length) {
                    stack.push(seq1[index++]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
