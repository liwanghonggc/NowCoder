package lwh.PointOffer;


public class Problem45_ConvertArrayToMinNum {

    public static void main(String[] args) {
        int[] arr = {3, 32, 321};
        System.out.println(printMinNum(arr));
    }

    private static String printMinNum(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        fastSort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    private static void fastSort(int[] arr){
        fastSort(arr, 0, arr.length - 1);
    }

    private static void fastSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int pivotIndex = getPartition(arr, left, right);
        fastSort(arr, left, pivotIndex - 1);
        fastSort(arr, pivotIndex + 1, right);
    }

    private static int getPartition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int tail = left - 1;
        for(int i = left; i < right; i++){
            if(oneLessThanTwo(arr[i], pivot)){
                swap(arr, ++tail, i);
            }
        }
        swap(arr, ++tail, right);
        return tail;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean oneLessThanTwo(int num1, int num2){
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        int res = (str1 + str2).compareTo(str2 + str1);
        return res <= 0;
    }
}
