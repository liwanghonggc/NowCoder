package lwh.PointOffer;

import java.util.Stack;

/**
 * @author lwh
 * @date 2018-09-17
 * @desp 两个栈实现一个队列
 */
public class Problem9_TwoStackGetQueue {

    private static final Stack<Integer> stack1 = new Stack<>();

    private static final Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队操作,直接将元素放到stack1中
     *
     * @param num
     */
    public void addToTail(Integer num) {
        stack1.push(num);
    }

    /**
     * 出队操作,若stack2非空,直接从Stack2中弹出一个元素;若Stack2为空,将stack1中元素依此弹出放入stack2中
     *
     * @return
     */
    public Integer getNumFormHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int num = stack1.pop();
                stack2.push(num);
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Problem9_TwoStackGetQueue queue = new Problem9_TwoStackGetQueue();
        queue.addToTail(1);
        queue.addToTail(2);
        queue.addToTail(3);

        System.out.println(queue.getNumFormHead());
        System.out.println(queue.getNumFormHead());
    }
}
