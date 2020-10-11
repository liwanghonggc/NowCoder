package lwh.leetcode;

public class Problem_231_PowerOfTwo_Easy {

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(20));
    }
}
