package lwh.codeguide.video;

import java.util.Stack;

/**
 * 用两个栈实现一个队列,支持队列的基本操作(add,poll,peek)
 * @author lwh
 *
 */
public class TwoStackToQueue2 {

	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	public void add(int x){
		stack1.push(x);
	}
	
	public int poll(){
		if(stack1.isEmpty() && stack2.isEmpty()){
			throw new RuntimeException("队列已空");
		}else if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	
	public int peek(){
		if(stack1.isEmpty() && stack2.isEmpty()){
			throw new RuntimeException("队列已空");
		}else if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
	
	public static void main(String[] args) {
		TwoStackToQueue2 t = new TwoStackToQueue2();
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
