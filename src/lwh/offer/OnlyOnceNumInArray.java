package lwh.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OnlyOnceNumInArray {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 2, 4, 4, 5, 7, 7};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + ", " + num2[0]);
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.remove(array[i]);
            } else {
                map.put(array[i], array[i]);
            }
        }
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        int[] a = new int[2];
        int i = 0;
        while (it.hasNext()) {
            a[i++] = it.next();
        }
        num1[0] = a[0];
        num2[0] = a[1];
    }

}
