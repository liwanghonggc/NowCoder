package lwh.linklist;

public class LinkListTest {

    public static void main(String[] args) {
        while (true) {
            LinkList list = new LinkList();
            list.createListHead();
            list.print();

            list.reverse3();

            list.print();
        }

//		Node n1 = new Node(1);
//		Node n2 = new Node(2, n1);
//		Node n3 = new Node(3, n2);
//		Node n4 = new Node(4, n3);
//		n1.next = n3;
//		
//		Node node = LinkList.isHaveCircle2(n4);
//		if(node == null){
//			System.out.println("无环");
//		}else{
//			System.out.println("有环,入环节点值是" + node.e);
//		}
    }

}
