package lwh.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Min_K_Num {

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

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }

        for (int i = 0; i < k; i++) {
            list.add(pq.poll());
        }
        return list;
    }

}
