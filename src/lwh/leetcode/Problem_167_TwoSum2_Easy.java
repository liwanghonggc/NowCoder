package lwh.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem_167_TwoSum2_Easy {

    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2){
            return null;
        }

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
