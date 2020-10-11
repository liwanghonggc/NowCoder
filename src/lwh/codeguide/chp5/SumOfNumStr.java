package lwh.codeguide.chp5;

import java.util.Scanner;

public class SumOfNumStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int sum = getSumOfNumStr(str);
            System.out.println(sum);
        }
    }

    private static int getSumOfNumStr(String str) {
        int sum = 0, num = 0;
        if (str == null || str.length() == 0) {
            return sum;
        }

        char[] ch = str.toCharArray();
        boolean flag = true;

        for (int i = 0; i < ch.length; i++) {
            int cur = ch[i] - '0';
            if (cur < 0 || cur > 9) {
                sum += num;
                num = 0;

                if (ch[i] == '-') {
                    if (i > 0 && ch[i - 1] == '-') {
                        flag = !flag;
                    } else {
                        flag = false;
                    }
                } else {
                    flag = true;
                }
            } else {
                num = num * 10 + (flag ? cur : -cur);
            }
        }

        sum += num;

        return sum;
    }
}
