package lwh.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;



public class PrintReverseSingleList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		
		ArrayList<Integer> list = printListFromTailToHead(n1);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> list = new ArrayList<>();
//        printList(list, listNode);
//        return list;
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		while(listNode != null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		return list;
		
    }

	private static void printList(ArrayList<Integer> list, ListNode listNode) {
//		if(listNode == null){
//			return;
//		}
		if(listNode.next != null){
			printList(list, listNode.next);
		}
		list.add(listNode.val);
	}

}
