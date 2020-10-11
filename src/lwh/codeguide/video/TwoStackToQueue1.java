package lwh.codeguide.video;

import java.util.Stack;

/**
 * 用两个栈实现一个队列,支持队列的基本操作(add,poll,peek)
 *
 * @author lwh
 */
public class TwoStackToQueue1 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(int x) {
        stack1.push(x);
    }

    public int poll() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int num = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return num;
    }

    public int peek() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int num = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return num;
    }

    public static void main(String[] args) {
        TwoStackToQueue1 t = new TwoStackToQueue1();
        t.add(5);
        t.add(4);


        System.out.println(t.poll());
        t.add(7);
        System.out.println(t.poll());
        System.out.println(t.peek());
        System.out.println(t.poll());
        System.out.println(t.poll());


    }

}
