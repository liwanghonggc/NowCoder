package lwh.sort;

/**
 * @author lwh
 * @date 2019-03-03
 * @desp
 */
public class ArraySort3 {

    //递归快速排序
    public static void fastSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        fastSort(arr, 0, arr.length - 1);
    }

    private static void fastSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int pivotIndex = partition(arr, left, right);
        fastSort(arr, left, pivotIndex - 1);
        fastSort(arr, pivotIndex, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int tail = left - 1;
        for(int i = left; i < right; i++){
            if(arr[i] < pivot){
                tail++;
                int temp = arr[i];
                arr[i] = arr[tail];
                arr[tail] = temp;
            }
        }
        int temp = arr[tail+1];
        arr[tail+1] = arr[right];
        arr[right] = temp;
        return tail + 1;
    }
}
