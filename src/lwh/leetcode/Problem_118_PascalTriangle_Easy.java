package lwh.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_118_PascalTriangle_Easy {

    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            Integer[] a = new Integer[i + 1];
            a[0] = 1;
            a[a.length - 1] = 1;
            for (int j = 1; j < a.length - 1; j++) {
                List<Integer> list = res.get(i - 1);
                a[j] = list.get(j - 1) + list.get(j);
            }
            List<Integer> list = Arrays.asList(a);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(6);
        System.out.println(res.toString());
    }
}
