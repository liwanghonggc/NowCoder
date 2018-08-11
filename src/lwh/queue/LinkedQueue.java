package lwh.queue;


import lwh.stack.Result;
import lwh.stack.SeqStack;

//带头节点的链式队列,头指针指向头节点,尾指针指向队尾节点
public class LinkedQueue {
	
	private Node front, rear;
	
	public LinkedQueue(){
		Node node = new Node();
		node.next = null;
		front = node;
		rear = node;
	}
	
	public boolean isEmpty(){
		if(front == rear){
			return true;
		}
		return false;
	}
	
	public void enQueue(int x){
		Node node = new Node(x);
		rear.next = node;
		rear = node;
	}
	
	public Result deQueue(){
		Result r = new Result();
		if(front == rear){
			r.setFlag(false);
			return r;
		}
		Node p = front.next;
		r.setFlag(true);
		r.setX(p.e);
		front.next = p.next;
		//链式队列删除元素时一般仅需修改头指针即可,但如果队列仅有一个元素,删除后元素为空,则需修改尾指针
		//将其指向头指针
		if(rear == p){
			rear = front;
		}
		p.next = null;
		p = null;
		return r;
	}
	
	//Q是一个队列,S是一个空栈,将队列元素逆置
	public void reverse(){
		SeqStack s = new SeqStack();
		while(!isEmpty()){
			s.push(deQueue().getX());
		}
		//s.print();
		while(!s.isEmpty()){
			Node node = new Node(s.pop().getX());
			rear.next = node;
			rear = node;
		}
	}
	
	//print()方法将队列元素输出后,队列就空了
	public void print(){
		if(isEmpty()){
			System.out.println("No num");
			return;
		}
		System.out.print("[");
		while(!isEmpty()){
			System.out.print(deQueue().getX() + ",");
		}
		System.out.println("]");
	}
}
