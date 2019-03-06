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

    /**
     * 递归快速排序
     */
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

    /**
     * 非递归快速排序
     */
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

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        buildHeap(arr);
        int heapSize = arr.length;
        while (heapSize > 1){
            heapSize--;
            int temp = arr[heapSize];
            arr[heapSize] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, heapSize);
        }
    }

    private static void buildHeap(int[] arr) {
        int heapSize = arr.length;
        for(int i = heapSize / 2 - 1; i >= 0; i--){
            heapify(arr, i, heapSize);
        }
    }

    private static void heapify(int[] arr, int i, int heapSize) {
        int lChild = 2 * i + 1;
        int rChild = 2 * i + 2;

        int max = i;

        if(lChild < heapSize && arr[lChild] > arr[max]){
            max = lChild;
        }
        if(rChild < heapSize && arr[rChild] > arr[max]){
            max = rChild;
        }

        if(max != i){
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            heapify(arr, max, heapSize);
        }
    }
}
