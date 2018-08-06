package lwh.offer;

public class FindGreatestSumOfSubArray2 {

	public static void main(String[] args) {
		int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
	public static int FindGreatestSumOfSubArray(int[] array) {
		int[] f = new int[array.length];
		f[0] = array[0];
		
		for(int i = 1; i < array.length; i++){
			if(f[i-1] <= 0){
				f[i] = array[i];
			}else{
				f[i] = f[i-1] + array[i];
			}
		}
		
		int max = f[0];
		for(int i = 1; i < f.length; i++){
			if(f[i] > max){
				max = f[i];
			}
		}
        return max;
    }

}
