package lwh.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MoreThanHalfTimesNum {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(a));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int num = map.get(array[i]);
                map.put(array[i], num + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        int len = array.length / 2;
        Set<Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Entry<Integer, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Entry<Integer, Integer> next = it.next();
            if (next.getValue() > len) {
                return next.getKey();
            }
        }
        return 0;
    }

}
