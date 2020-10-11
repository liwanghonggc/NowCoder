package lwh.codeguide.video;

import java.util.Stack;

//将最大元素压入到help栈的最底层
public class SortStackByStack2 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> help = new Stack<>();

    public void sort() {
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public void printStack() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortStackByStack2 s = new SortStackByStack2();
        s.stack.push(5);
        s.stack.push(6);
        s.stack.push(2);
        s.stack.push(7);
        s.stack.push(1);
        s.stack.push(5);
        s.stack.push(9);

        s.sort();

        s.printStack();

    }

}
