package lwh.offer;

public class ReverseSentence {

    public static void main(String[] args) {
        String str = " ";
        System.out.println(ReverseSentence(str));
    }

    public static String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        if (str.trim().equals("")) {
            return str;
        }

        str = new StringBuilder(str).reverse().toString();
        String[] s = str.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            String temp = new StringBuilder(s[i]).reverse().toString();
            sb.append(temp);
            if (i != s.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
