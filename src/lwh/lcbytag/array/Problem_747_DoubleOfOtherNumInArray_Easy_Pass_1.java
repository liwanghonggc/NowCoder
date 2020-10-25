package lwh.lcbytag.array;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @author lwh
 * @date 2020-10-25
 * @desp 在一个给定的数组nums中, 总是存在一个最大元素 .
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍.
 * <p>
 * 如果是,则返回最大元素的索引,否则返回-1.
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍.6的索引是1, 所以我们返回1.
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * <p>
 * 来源: 力扣(LeetCode)
 * 链接: https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 */
public class Problem_747_DoubleOfOtherNumInArray_Easy_Pass_1 {

    public static void main(String[] args) {
        int[] a1 = {3, 6, 1, 0};
        int[] a2 = {1, 2, 3, 4};
        int[] a3 = {1, 4, 2, 8, 9, 20, 5, 40};
        int[] a4 = {8, 4, 3, 9, 19, 5};
        int[] a5 = {4, 2, 8, 9, 4, 7, 10, 15};
        int[] a6 = {1};

        System.out.println(dominantIndex(a1));
        System.out.println(dominantIndex(a2));
        System.out.println(dominantIndex(a3));
        System.out.println(dominantIndex(a4));
        System.out.println(dominantIndex(a5));
        System.out.println(dominantIndex(a6));
    }

    public static int dominantIndex(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int max = Math.max(nums[0], nums[1]);
        int lessThanMax = Math.min(nums[0], nums[1]);
        boolean flag = max >= lessThanMax * 2;
        int indexOfMax = flag ? (max == nums[0] ? 0 : 1) : -1;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] <= lessThanMax) {
                continue;
            }
            if (nums[i] > max) {
                lessThanMax = max;
                max = nums[i];
                flag = max >= lessThanMax * 2;
                indexOfMax = flag ? i : -1;
                continue;
            }
            if (nums[i] == max) {
                flag = false;
                lessThanMax = max;
                continue;
            }
            if (nums[i] > lessThanMax && nums[i] < max) {
                lessThanMax = nums[i];
                flag = max >= lessThanMax * 2;
                indexOfMax = flag ? indexOfMax : -1;
            }
        }

        return flag ? indexOfMax : -1;
    }
}
