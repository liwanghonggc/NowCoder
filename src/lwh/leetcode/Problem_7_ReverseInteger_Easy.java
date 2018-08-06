package lwh.leetcode;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
 * 根据这个假设，如果反转后的整数溢出，则返回 0
 *
 * 输入: 123
 * 输出: 321
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 */
public class Problem_7_ReverseInteger_Easy {

    public static int reverse_1(int x){
        if(x == Integer.MIN_VALUE){
            return 0;
        }

        boolean flag = false;
        if(x < 0){
            flag = true;
            x = 0 - x;
        }

        char[] chs = String.valueOf(x).toCharArray();
        int len = chs.length;
        for (int i = 0; i < len / 2; i++){
            char temp = chs[i];
            chs[i] = chs[len - 1 - i];
            chs[len - 1 - i] = temp;
        }

        long num = Long.parseLong(new String(chs));
        if(num > Integer.MAX_VALUE){
            return 0;
        }

        if(flag == true){
            num = 0 - num;
        }

        return (int)num;
    }

    public static int reverse_2(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int x = -120;
        System.out.println(reverse_2(x));
    }
}
