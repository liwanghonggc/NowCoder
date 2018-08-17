package lwh.sort;

public class MyArraySort {

    // 冒泡
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 选择
    public static void selectSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }

        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                swap(arr, i, minIndex);
            }
        }
    }

    // 插入

    // 快排
    public static void fastSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }

        doFastSort(arr, 0, arr.length - 1);
    }

    private static void doFastSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }

        int pivotIndex = getPivotIndex(arr, left, right);
        doFastSort(arr, left, pivotIndex - 1);
        doFastSort(arr, pivotIndex + 1, right);
    }

    private static int getPivotIndex(int[] arr, int left, int right) {
        int pivot = arr[right];
        int tail = left - 1;
        for(int i = left; i < right; i++){
            if(arr[i] <= pivot){
                swap(arr, ++tail, i);
            }
        }
        swap(arr, ++tail, right);
        return tail;
    }

    // 归并
    public static void mergeSort(int[] arr){
        if(arr != null && arr.length <= 1){
            return;
        }

        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }

        int mid = (left + right) / 2;
        mergeSortRecursive(arr, left, mid);
        mergeSortRecursive(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= right){
            temp[index++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while(i <= mid){
            temp[index++] = arr[i++];
        }
        while(j <= right){
            temp[index++] = arr[j++];
        }
        for(int k = 0; k < len; k++){
            arr[left++] = temp[k];
        }
    }

    // 堆排序

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
