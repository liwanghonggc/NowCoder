package lwh.leetcode;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem_172_FactorialTrailingZeroes_Easy {

    public static int trailingZeroes(int n) {
        if(n <= 0){
            return 0;
        }

        int count = 0;
        while(n > 0){
            count += (n / 5);
            n /= 5;
        }
        return count;
    }

    public static BigInteger fac(int n){
        if(n == 1){
            return new BigInteger("1");
        }
        return fac(n - 1).multiply(new BigInteger(n + ""));
    }

    public static void main(String[] args) {
        System.out.println(fac(45));
        System.out.println(trailingZeroes(45));
    }
}
