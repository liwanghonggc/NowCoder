package lwh.leetcode;

public class Problem_69_Sqrt_Easy {

    public static int sqrt_1(int x) {
        long left = 0;
        long right = x;
        long mid = (left + right) / 2;
        while (left <= right) {
            long r1 = mid * mid;
            long r2 = (mid + 1) * (mid + 1);
            if (r1 == x || (r1 < x && r2 > x)) {
                return (int) mid;
            }
            if (r2 == x) {
                return (int) mid + 1;
            }
            if (r2 < x) {
                left = mid + 1;
            }
            if (r1 > x) {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    public static int sqrt_2(int x) {
        int left = 1, right = x / 2 + 1, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sqrt_2(24));
    }
}
