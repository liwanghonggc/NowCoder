package lwh.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintMinNumber2 {

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        System.out.println(PrintMinNumber(numbers));
    }

    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new NumComparator());

        String res = "";
        for (Integer i : list) {
            res += i;
        }

        return res;
    }

    public static class NumComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            String aStr = String.valueOf(a);
            String bStr = String.valueOf(b);

            String c = aStr + bStr;
            String d = bStr + aStr;

            return c.compareTo(d);
        }
    }

}
