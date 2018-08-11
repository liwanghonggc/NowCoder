package lwh.codeguide.video;

public class SplitArray {

	public static int getMax1(int[] a){
		int max = Integer.MIN_VALUE;
		int n = a.length;
		for(int i = 0; i < n; i++){
			max = Math.max(max, a[i]);
		}
		int temp = a[0] < a[n-1] ? a[0] : a[n-1];
		return max - temp;
	}
	
	//先准备好两个辅助数组
	public static int getMax2(int[] a){
		int n = a.length;
		int[] b = new int[n];
		b[0] = a[0];
		int[] c = new int[n];
		c[n-1] = a[n-1];
		for(int i = 1; i < n; i++){
			b[i] = Math.max(a[i], b[i-1]);
		}
		for(int i = n - 2; i >= 0; i--){
			c[i] = Math.max(a[i], c[i+1]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < n; i++){
			int temp = Math.abs(b[i]-c[i]);
			max = Math.max(max, temp);
		}
		return max;
	}
	
	public static void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {3,5,8,9,2,5,7,1};
		System.out.println(getMax2(a));
	}

}
