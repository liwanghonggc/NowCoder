package lwh.codeguide.chp5;

import java.util.Scanner;

public class StringToInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(parseInt(str));
        }
    }

    private static int parseInt(String str) {
        if (!isValid(str)) {
            return 0;
        }

        char[] chs = str.toCharArray();
        boolean flag = chs[0] == '-' ? false : true;

        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;

        int res = 0;
        int cur = 0;

        for (int i = flag ? 0 : 1; i < chs.length; i++) {
            cur = '0' - chs[i];
            if (res < minq || (res == minq && cur < minr)) {
                return 0;
            }
            res = res * 10 + cur;
        }

        if (flag && res == Integer.MIN_VALUE) {
            return 0;
        }

        return flag ? -res : res;
    }

    private static boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        char[] chs = str.toCharArray();
        if (chs[0] != '-' && (chs[0] > '9' || chs[0] < '0')) {
            return false;
        }
        if (chs[0] == '-' && (chs.length == 1 || chs[1] == '0')) {
            return false;
        }
        if (chs[0] == '0' && chs.length > 1) {
            return false;
        }

        for (int i = 1; i < chs.length; i++) {
            if (chs[i] > '9' || chs[i] < '0') {
                return false;
            }
        }

        return true;
    }
}
