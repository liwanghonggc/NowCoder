package lwh.queue;


import lwh.stack.Result;

//顺序存储的循环队列
public class CircularSeqQueue {

	private static final int maxLen = 7;
	private int front;
	private int rear;
	private int[] a;
	
	public CircularSeqQueue(){
		a = new int[maxLen];
		front = rear = 0;
	}
	
	public boolean isEmpty(){
		return front == rear;
	}
	
	public boolean isFull(){
		return (rear+1)%maxLen == front;
	}
	
	public int length(){
		return (rear-front+maxLen)%maxLen;
	}
	
	public boolean enQueue(int x){
		if(isFull()){
			return false;
		}
		a[rear] = x;
		rear = (rear+1)%maxLen;
		return true;
	}
	
	public Result deQueue(){
		Result r = new Result();
		if(isEmpty()){
			r.setFlag(false);
			return r;
		}
		r.setX(a[front]);
		front = (front+1)%maxLen;
		return r;
	}
}
