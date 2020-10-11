package lwh.codeguide.chp5;

import java.util.Scanner;

public class RotateWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();

            System.out.println(isRotateWord(str1, str2));
        }
    }

    private static boolean isRotateWord(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        str1 = str1 + str1;

        if (str1.contains(str2)) {
            return true;
        }
        return false;
    }
}
