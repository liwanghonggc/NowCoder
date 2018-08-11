package lwh.codeguide.video;


import lwh.linklist.LinkList;
import lwh.linklist.Node;

public class DeleteKNodeInSingleList {

	public int length(Node head){
		int count = 0;
		while(head != null){
			count++;
			head = head.next;
		}
		return count;
	}
	
	public void deleteNode(Node head, int k){
		int length = length(head);
		int len = length - k;
		if(k <= 0 || k > len){
			throw new RuntimeException("k值不合法");
		}
		if(len == 0){
			head = head.next;
			return;
		}
		Node p = null;
		while(len > 0 && head != null){
			p = head;
			head = head.next;
			len--;
		}
		p.next = head.next;
		head.next = null;
		head = null;
	}
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.createListHead();
		list.print();
		list.delete(3);
		list.print();
	}

}
