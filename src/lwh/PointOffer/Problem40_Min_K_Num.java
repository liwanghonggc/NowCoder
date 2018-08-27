package lwh.PointOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem40_Min_K_Num {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8, 0};
        getMinKNum(arr, 4);
    }

    private static void getMinKNum(int[] arr, int k){
        if(arr == null || arr.length < k){
            return;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0; i < k; i++){
            queue.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            int num = queue.peek();
            if(arr[i] < num){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        while(!queue.isEmpty()){
            System.out.print(queue.poll() + ", ");
        }

        System.out.println();
    }
}
