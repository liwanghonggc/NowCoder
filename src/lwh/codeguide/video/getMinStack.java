package lwh.codeguide.video;

import java.util.Stack;

/**
 * 设计一个特殊的栈,在实现栈基本功能的基础上,再实现返回栈中最小值
 *
 * @author lwh
 */
public class getMinStack {

    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stackData.pop();
        if (value == this.getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x <= this.getMin()) {
            stackMin.push(x);
        }
        stackData.push(x);
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        getMinStack s = new getMinStack();
        s.push(1);
        s.push(3);
        s.push(-1);
        s.push(5);
        s.push(-4);
        s.push(9);
        s.push(-1);

        System.out.println(s.getMin());
        System.out.println(s.getMin());
        System.out.println(s.getMin());
    }
}
