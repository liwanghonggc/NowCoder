package lwh.PointOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 滑动窗口的最大值 **/
public class Problem59_MaxValueOfQueue1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        System.out.println(Arrays.toString(maxWindow));

        List<Integer> res = new ArrayList<>();

    }

    private static int[] getMaxWindow(int[] arr, int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;

        for(int i = 0; i < arr.length; i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst() == i - w){
                qmax.pollFirst();
            }
            if(i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }

        return res;
    }
}
