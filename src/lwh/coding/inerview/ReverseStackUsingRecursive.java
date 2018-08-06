package lwh.coding.inerview;

import java.util.Stack;

public class ReverseStackUsingRecursive {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.toString());

        reverse(stack);

        System.out.println(stack.toString());
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    //每次找栈底元素并删除
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
