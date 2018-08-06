package lwh.offer;

public class DuplicateNumInArray {

	public static void main(String[] args) {
		int[] a = {4,7,3,1,0,2,6,5};
		int[] duplication = new int[a.length];
		boolean flag = duplicate(a, a.length, duplication);
		if(flag){
			System.out.println(duplication[0]);
		}else{
			System.out.println("No duplicate num!");
		}
	}
	
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
	    if(numbers == null || length == 0){
	    	return false;
	    }
	    Integer[] table = new Integer[length];
	    for(int i = 0;i < length; i++){
	    	int index = numbers[i];
	    	if(table[index] == null){
	    		table[index] = index;
	    	}else{
	    		duplication[0] = table[index];
	    		return true;
	    	}
	    	
	    }
	    return false;
    }

}
