package lwh.offer;

public class LeftRotateString {

    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(LeftRotateString(str, 3));
    }

    public static String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0){
            return str;
        }

        int len = str.length();
        n = n % len;
        char[] chs = new char[len];

        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int index = (i - n + len) % len;
            chs[index] = c;
        }

        return new String(chs);
    }
}
