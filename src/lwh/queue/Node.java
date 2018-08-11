package lwh.queue;

public class Node {
	protected int e;
	protected Node next;
	
	public Node(){};
	
	public Node(int e){
		this.e = e;
	}
	
	public Node(int e, Node next){
		this.e = e;
		this.next = next;
	}
}
