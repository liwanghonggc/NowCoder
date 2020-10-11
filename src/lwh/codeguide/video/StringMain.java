package lwh.codeguide.video;

import java.util.Scanner;

public class StringMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str == null || str.length() == 0) {
                System.out.println(-1);
            } else {
                int len = palindrome(str);
                System.out.println(len);
            }

        }
    }

    public static int palindrome(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            temp += str.charAt(str.length() - i - 1);
            temp = temp.substring(0, 6);
        }
        int len = temp.length();
        return len;
    }

}
