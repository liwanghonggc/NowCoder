package lwh.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Problem_1_TwoSum_Easy {

    public static int[] twoSum_1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(temp);

        int i = 0;
        int j = temp.length - 1;

        while (i < j) {
            int sum = temp[i] + temp[j];
            if (sum == target) {
                int index1 = getIndex(nums, temp[i], true);
                int index2 = getIndex(nums, temp[j], false);
                return new int[]{index1, index2};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    private static int getIndex(int[] nums, int target, boolean flag) {
        if (flag) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
        } else {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 10};
        int[] index = twoSum_2(nums, 12);
        System.out.println(index[0]);
        System.out.println(index[1]);
    }
}
