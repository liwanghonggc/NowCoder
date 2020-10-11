package lwh.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Problem_119_PascalTriangle2_Easy {

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }

        Integer[] a = new Integer[rowIndex + 1];
        int mid = rowIndex / 2;

        for (int i = 0; i <= mid; i++) {
            a[i] = calculate(rowIndex, i);
        }

        for (int i = mid + 1; i < a.length; i++) {
            int diff = i - mid;
            if (rowIndex % 2 == 1) {
                a[i] = a[mid - diff + 1];
            } else {
                a[i] = a[mid - diff];
            }

        }
        return Arrays.asList(a);
    }

    private static int calculate(int rowIndex, int r) {
        if (r > rowIndex - r) {
            r = rowIndex - r;
        }

        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (rowIndex - i);
            res /= (i + 1);
        }
        return (int) res;
    }


    public static void main(String[] args) {
        List<Integer> res = getRow(21);
        System.out.println(res.toString());

    }
}
