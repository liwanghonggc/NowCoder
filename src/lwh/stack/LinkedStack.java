package lwh.stack;

//栈的链式实现,不带头节点,插入删除操作都是在链表的表头实现
public class LinkedStack {

	private Node head;
	
	public LinkedStack(){
		head = null;
	}
	
	public void insertHead(int x){
		Node node = new Node(x);
		node.next = head;
		head = node;
	}
	
	public int length(){
		int i = 0;
		for(Node node = head; node != null; node = node.next){
			i++;
		}
		return i;
	}
	
	//判断链式存储的栈前n个字符是否中心对称
	public boolean isSymmetry(){
		SeqStack s = new SeqStack();
		Node p = head;
		boolean flag = true;
		for(int i = 1; i <= length()/2; i++){
			s.push(p.e);
			p = p.next;
		}
		if(length() % 2 == 1){
			p = p.next;
		}
		while(p != null){
			int x = s.pop().getX();
			if(x == p.e){
				p = p.next;
			}else{
				flag = false;
				break;
			}
		}
		return flag;
		
	}
	
	public void print(){
		if(head == null){
			System.out.println("No num");
			return;
		}
		System.out.print("[");
		for(Node node = head; node != null; node = node.next){
			if(node.next != null){
				System.out.print(node.e + ",");
			}else{
				System.out.print(node.e);
			}
		}
		System.out.println("]");
	}
}
