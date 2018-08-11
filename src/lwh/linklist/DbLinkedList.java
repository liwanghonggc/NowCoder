package lwh.linklist;

//带头节点的双链表
public class DbLinkedList {

	private DbNode head;
	
	public DbLinkedList(){
		head = new DbNode();
		head.next = null;
		head.previous = null;
	}
	
	//在头节点后面插入节点
	public void insertHead(int num){
		DbNode node = new DbNode(num);
		DbNode p = head.next;
		if(p != null){
			node.next = p;
			p.previous = node;
			node.previous = head;
			head.next = node;
		}else{
			head.next = node;
			node.previous = head;
		}
	}
	
	//求表长,不包括表头节点
	public int length(){
		int len = 0;
		DbNode p = head.next;
		while(p != null){
			len++;
			p = p.next;
		}
		return len;
	}
	
	//删除i处的节点
	public boolean delete(int i){
		if(i < 1 || i > length()){
			System.out.println("Delete index wrong");
			return false;
		}
		DbNode q = head.next;
		int j = 1;
		while(j < i){
			q = q.next;
			j++;
		}
		DbNode r = q.next;
		DbNode p = q.previous;
		if(r != null){
			p.next = r;
			r.previous = p;
			q = null;
		}else{
			p.next = null;
			q = null;
		}
		return true;
	}
	
	public void print() {
		if(head.next == null){
			System.out.println("No num");
			return;
		}
		System.out.print("[");
		for(DbNode node = head.next; node != null; node = node.next){
			if(node.next != null)
				System.out.print(node.e + ",");
			else
				System.out.print(node.e + "]");
		}
		System.out.println();
	}
	
	//删除双链表的倒数第k个节点
	public void deleteNode(int k){
		if(k < 1 || head.next == null){
			return;
		}
		DbNode cur = head.next;
		while(cur != null){
			k--;
			cur = cur.next;
		}
		if(k == 0){
			head.next = head.next.next;
			head.next.previous = head;
		}
		if(k < 0){
			cur = head.next;
			while(++k != 0){
				cur = cur.next;
			}
			DbNode q = cur.next.next;
			cur.next = q;
			if(q != null){
				q.previous = cur;
			}
		}
	}
}
