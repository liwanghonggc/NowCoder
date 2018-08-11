package lwh.linklist;

public class Node {

	public int e;
	public Node next;
	
	public Node(){};
	
	public Node(int e){
		this.e = e;
	}
	
	public Node(int e, Node next){
		this.e = e;
		this.next = next;
	}
}
