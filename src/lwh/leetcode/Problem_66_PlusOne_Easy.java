package lwh.leetcode;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem_66_PlusOne_Easy {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len - 1] += 1;
        if (digits[len - 1] < 10) {
            return digits;
        } else {
            digits[len - 1] %= 10;
        }

        for (int i = len - 2; i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] %= 10;
            }
        }

        int[] res = new int[len + 1];
        res[0] = 1;
        System.arraycopy(digits, 0, res, 1, len);
        return res;
    }

    public static void main(String[] args) {
        int[] digitis = {9, 9, 9};
        int[] res = plusOne(digitis);
        System.out.println(Arrays.toString(res));
    }
}
