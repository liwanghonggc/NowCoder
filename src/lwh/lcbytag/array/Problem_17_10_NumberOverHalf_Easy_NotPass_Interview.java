package lwh.lcbytag.array;

/**
 * @author lwh
 * @date 2020-10-25
 * @desp 数组中占比超过一半的元素称之为主要元素.给定一个整数数组, 找到它的主要元素.若没有, 返回-1.
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,5,9,5,9,5,5,5]
 * 输出: 5
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2]
 * 输出: -1
 *  
 * <p>
 * 示例 3:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *  
 * <p>
 * 说明:
 * 你有办法在时间复杂度为 O(N),空间复杂度为 O(1) 内完成吗?
 * <p>
 * 通过次数17,947提交次数29,276
 * <p>
 * 来源: 力扣(LeetCode)
 * 链接: https://leetcode-cn.com/problems/find-majority-element-lcci
 */
public class Problem_17_10_NumberOverHalf_Easy_NotPass_Interview {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int[] a2 = {3, 2};
        int[] a3 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(a1));
        System.out.println(majorityElement(a2));
        System.out.println(majorityElement(a3));
    }

    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }

        int len = nums.length / 2 + 1;
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            }
            if (count == len) {
                return temp;
            }
        }
        return -1;
    }
}
