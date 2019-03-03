package lwh.sort;

public class SortTest {

	public static void main(String[] args) {
		int[] a = {5,4,3,1,7,6,9,8,2};
		
		ArraySort3.fastSort(a);
		print(a);
		
	}

	public static void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
}
