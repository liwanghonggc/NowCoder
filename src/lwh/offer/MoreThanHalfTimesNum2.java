package lwh.offer;

public class MoreThanHalfTimesNum2 {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		System.out.println(MoreThanHalfNum_Solution(a));
	}
	
	public static int MoreThanHalfNum_Solution(int [] array) {
		if(array == null || array.length == 0){
			return 0;
		}
        
		int num = array[0];
		int count = 1;
		for(int i = 1; i < array.length; i++){
			if(num == array[i]){
				count++;
			}else{
				if(count == 1){
					num = array[i];
				}else{
					count--;
				}
			}
		}
		
		if(checkMoreThanHalf(array, num)){
			num = 0;
		}
		return num;
    }

	private static boolean checkMoreThanHalf(int[] array, int num) {
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] == num){
				count++;
			}
		}
		if(count * 2 <= array.length){
			return true;
		}
		return false;
	}

}
