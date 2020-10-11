package lwh.leetcode;

import java.util.Stack;
/**
 *
 */
public class Problem_155_MinStack_Easy {

    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> help;

        public MinStack() {
            stack = new Stack<>();
            help = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (help.isEmpty()) {
                help.push(x);
            } else {
                int temp = help.peek();
                if (temp < x) {
                    help.push(temp);
                } else {
                    help.push(x);
                }
            }
        }

        public void pop() {
            stack.pop();
            help.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return help.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());

        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin());
    }
}
