package lwh.queue;

public class ArrayQueue {

	public int[] a;
	public int size;
	public int start;//存放出去的数的位置
	public int end;  //存放要进来的数的位置
	
	public ArrayQueue(int len){
		if(len < 0){
			throw new RuntimeException("队列初始化长度小于0");
		}
		a = new int[len];
		size = 0;
		start = 0;
		end = 0;
	}
	
	public int peek(){
		if(size <= 0){
			throw new RuntimeException("队列元素已空");
		}
		return a[start];
	}
	
	public void push(int x){
		if(size == a.length){
			throw new RuntimeException("队列元素已满");
		}
		a[end] = x;
		if(end + 1 == a.length){
			end = 0;
		}else{
			end++;
		}
		size++;
	}
	
	public int pop(){
		if(size <= 0){
			throw new RuntimeException("队列元素已空");
		}
		int num = a[start];
		if(start + 1 == a.length){
			start = 0;
		}else{
			start++;
		}
		size--;
		return num;
	}
	
	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(4);
		
		q.push(5);
		q.push(4);
		System.out.println(q.pop());
		System.out.println(q.peek());
		System.out.println(q.peek());
		q.push(6);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
	}
	
}
