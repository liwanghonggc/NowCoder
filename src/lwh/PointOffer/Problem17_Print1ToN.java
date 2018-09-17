package lwh.PointOffer;

import java.util.Arrays;

/**
 * @author lwh
 * @date 2018-09-17
 * @desp 打印从1到n的最大n位数
 */
public class Problem17_Print1ToN {

    public static void main(String[] args) {
        int num = 3;
        printToMax(num);
    }

    public static void printToMax(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number, '0');
        printOrder(number, n, 0);
    }

    public static void printOrder(char[] number, int n, int loc) {
        if (loc == n) {
            return;
        }
        for (int i = 0; i <= 9; i++) {
            number[loc] = (char) ('0' + i);
            if (loc == n - 1) {
                printNumber(number);
            }
            printOrder(number, n, loc + 1);
        }
    }

    /**
     * 去除前面的0之后输出,如char[] ch = {'0', '2', '1'},输出21
     * @param num
     */
    public static void printNumber(char[] num) {
        int size = num.length;
        int i = 0;
        while (i < size && num[i] == '0') {
            i++;
        }

        if (i == size) {
            return;
        }
        char[] printNum = Arrays.copyOfRange(num, i, size);
        System.out.println(printNum);
    }
}
