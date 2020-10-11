package lwh.codeguide.chp5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(isUniqueChar1(str));
        }
    }

    /**
     * 时间复杂度O(n)
     **/
    private static boolean isUniqueChar1(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        char[] chs = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chs.length; i++) {
            if (set.contains(chs[i])) {
                return false;
            }
            set.add(chs[i]);
        }

        return true;
    }
}
