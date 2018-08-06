package lwh.leetcode;

import java.util.Arrays;

public class Problem_66_PlusOne_Easy {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len-1] += 1;
        if(digits[len-1] < 10){
            return digits;
        }else {
            digits[len-1] %= 10;
        }

        for (int i = len - 2; i >= 0; i--){
            digits[i] += 1;
            if(digits[i] < 10){
                return digits;
            }else{
                digits[i] %= 10;
            }
        }

        int[] res = new int[len+1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, len);
        return res;
    }

    public static void main(String[] args) {
        int[] digitis = {9,9,9};
        int[] res = plusOne(digitis);
        System.out.println(Arrays.toString(res));
    }
}
