package lwh.offer;

public class NumberOf1Between1AndN_Solution {

	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(13));
	}
	
	public static int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		for(int i = 1; i <= n; i++){
			char[] chs = String.valueOf(i).toCharArray();
			for(int j = 0; j < chs.length; j++){
				if(chs[j] == '1'){
					count++;
				}
			}
			
		}
	    return count;
    }

}
