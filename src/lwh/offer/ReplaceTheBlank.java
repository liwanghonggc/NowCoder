package lwh.offer;

public class ReplaceTheBlank {

	public static void main(String[] args) {
		String s = "We are happy";
		StringBuffer sb = new StringBuffer(s);
		System.out.println(replaceSpace(sb));
	}
	
	public static String replaceSpace(StringBuffer str) {
		String s = str.toString();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c != 32){
				sb.append(c);
			}else{
				sb.append("%20");
			}
		}
    	return sb.toString();
    }

}
