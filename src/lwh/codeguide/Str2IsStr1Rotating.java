package lwh.codeguide;


//判断str2是不是由str1循环右移得到的
public class Str2IsStr1Rotating {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "bcda";
        System.out.println(isRotating(str1, str2));
    }

    public static boolean isRotating(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        str1 = str1 + str1;
        if (str1.contains(str2)) {
            return true;
        }
        return false;
    }
}
