package lwh.offer;

public class GetNumberOfK {

	public static void main(String[] args) {
		int[] array = {3,3,3,4,5,5,8,8};
		System.out.println(GetNumberOfK2(array, 8));
	}
	
	public static int GetNumberOfK1(int [] array , int k) {
		if(array == null || array.length == 0){
			return 0;
		}
		
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(k == array[i]){
				count++;
				continue;
			}
			if(k < array[i]){
				return count;
			}
			
		}
	    return count;
    }
	
	public static int GetNumberOfK2(int [] array , int k) {
		if(array == null || array.length == 0){
			return 0;
		}
		
		int index = indexOfK(array, k, 0, array.length - 1);
		if(index == -1){
			return 0;
		}
		
		int count = 1;
		int temp = index + 1;
		while(temp <= array.length - 1){
			if(k == array[temp]){
				count++;
				temp++;
			}else{
				break;
			}
		}
		
		temp = index - 1;
		while(temp >= 0){
			if(k == array[temp]){
				count++;
				temp--;
			}else{
				break;
			}
		}
	    return count;
    }

	private static int indexOfK(int[] a, int k, int left, int right) {
		if(left > right){
			return -1;
		}
		int mid = (left + right) / 2;
		if(a[mid] == k){
			return mid;
		}else if(a[mid] < k){
			return indexOfK(a, k, mid + 1, right);
		}else{
			return indexOfK(a, k, left, mid - 1);
		}
	}

}
