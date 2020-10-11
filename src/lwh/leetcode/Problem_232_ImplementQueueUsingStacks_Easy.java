package lwh.leetcode;

import java.util.Stack;

public class Problem_232_ImplementQueueUsingStacks_Easy {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> help;

    public MyQueue() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (help.isEmpty()) {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
        return help.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (help.isEmpty()) {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
        return help.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return help.isEmpty() && stack.isEmpty();
    }
}