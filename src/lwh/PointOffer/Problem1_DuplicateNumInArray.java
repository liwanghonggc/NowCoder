package lwh.PointOffer;

public class Problem1_DuplicateNumInArray {

	public static void main(String[] args) {
		int[] arr = {4,7,3,1,0,1,6,5};
		int index = duplicate(arr);
		if(index == -1){
			System.out.println("不存在重复数字");
		}else{
			System.out.println(arr[index]);
		}

	}

	/**
	 * 返回重复数字的下标
	 * @param arr
	 * @return
	 */
	public static int duplicate(int[] arr) {
		if(arr == null || arr.length < 2){
			return -1;
		}

		for(int i = 0; i < arr.length; i++){
			while(arr[i] != i){
				if(arr[i] == arr[arr[i]]){
					return i;
				}
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}

		return -1;
    }

}
