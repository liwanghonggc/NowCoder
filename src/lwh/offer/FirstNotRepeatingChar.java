package lwh.offer;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {

	public static void main(String[] args) {
		String str = "abaccdeff";
		System.out.println(FirstNotRepeatingChar(str));
	}
	
	public static int FirstNotRepeatingChar(String str) {
		if(str == null || str.length() == 0){
			return -1;
		}
		
		char[] chs = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < chs.length; i++){
			Integer num = map.get(chs[i]);
			if(num == null){
				map.put(chs[i], 1);
			}else{
				map.put(chs[i], num + 1);
			}
		}
		
		for(int i = 0; i < chs.length; i++){
			if(map.get(chs[i]) == 1){
				return i;
			}
		}
        return -1;
    }

}
