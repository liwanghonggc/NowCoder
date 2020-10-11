package lwh.offer;

import java.util.ArrayList;
import java.util.List;

public class Min_K_Num2 {

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> list = GetLeastNumbers_Solution(input, 4);
        System.out.println(list);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (input == null || k <= 0 || k > input.length) {
            return list;
        }


        return list;
    }

}
