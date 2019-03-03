package lwh.sort;

import java.util.Stack;

/**
 * @author lwh
 * @date 2019-03-03
 * @desp
 */
public class ArraySort3 {

    //递归快速排序
    public static void fastSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        fastSort2(arr, 0, arr.length - 1);
    }

    private static void fastSort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(arr, left, right);
        fastSort1(arr, left, pivotIndex - 1);
        fastSort1(arr, pivotIndex, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int tail = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                tail++;
                int temp = arr[i];
                arr[i] = arr[tail];
                arr[tail] = temp;
            }
        }
        int temp = arr[tail + 1];
        arr[tail + 1] = arr[right];
        arr[right] = temp;
        return tail + 1;
    }

    private static void fastSort2(int[] a, int low, int high) {
        if(low >= high){
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();

            int pivot = partition(a, low, high);

            if(low < pivot - 1){
                stack.push(low);
                stack.push(pivot - 1);
            }

            if(pivot + 1 < high){
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }
}
