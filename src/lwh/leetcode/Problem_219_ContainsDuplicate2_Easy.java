package lwh.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_219_ContainsDuplicate2_Easy {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                if(Math.abs(index - i) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate_2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(containsNearbyDuplicate(nums, 0));
    }
}
