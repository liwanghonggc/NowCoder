package lwh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_225_ImplementStackUsingQueue_Easy {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}

class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> help;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int count = 0;
        int x = 0;
        while (!queue.isEmpty()) {
            x = queue.poll();
            help.add(x);
            count++;
        }

        while (count > 1) {
            queue.add(help.poll());
            count--;
        }
        help = new LinkedList<>();
        return x;
    }

    /**
     * Get the top element.
     */
    public int top() {
        int count = 0;
        int x = 0;
        while (!queue.isEmpty()) {
            x = queue.poll();
            help.add(x);
            count++;
        }

        while (count > 0) {
            queue.add(help.poll());
            count--;
        }
        return x;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}