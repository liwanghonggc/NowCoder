package lwh.codeguide.video;

public class DutchFlag {

	public static int[] partition(int[] a, int l, int r, int num){
		int left = l - 1;
		int right = r + 1;
		int i = l;
		while(i < right){
			if(a[i] < num){
				swap(a, ++left, i++);
			}else if(a[i] == num){
				i++;
			}else{
				swap(a, --right, i);
			}
		}
		return new int[]{left+1, right-1};
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		 int[] a = {2,8,3,5,6,4,5,1,7,9};
		 print(a);
		 partition(a, 0, a.length - 1, 5);
		 print(a);
	}

}
