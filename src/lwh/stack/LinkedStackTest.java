package lwh.stack;

public class LinkedStackTest {

	public static void main(String[] args) {
		LinkedStack s = new LinkedStack();
		s.insertHead(1);
		s.insertHead(2);
		s.insertHead(3);
		s.insertHead(2);
		s.insertHead(1);
		
		s.print();
		System.out.println(s.isSymmetry());
	}

}
