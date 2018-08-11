package lwh.seqlist;


public class SeqListTest {

	public static void main(String[] args) {
		//int[] b = {-1,4,6,8,9,11};
		SeqList s = new SeqList(10);
		s.insert(-1, 23);
		s.insert(-1, 13);
		s.insert(-1, 15);
		s.insert(-1, 29);
		s.insert(-1, 27);
		s.insert(-1, 1);
		s.insert(-1, 2);
		s.insert(-1, 3);
		s.insert(-1, 4);
		s.print();
		
		s.switchArray();
		s.print();

	}

}
