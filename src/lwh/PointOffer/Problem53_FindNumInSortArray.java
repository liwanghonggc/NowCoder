package lwh.PointOffer;

/** 时间复杂度O(logn) **/
public class Problem53_FindNumInSortArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        int count = getCountOfNum(arr, 3);
        System.out.println(count);
    }

    private static int getCountOfNum(int[] arr, int num) {
        if(arr == null || arr.length == 0){
            return 0;
        }

        int leftIndex = getFirstIndex(arr, num, 0, arr.length - 1);
        int rightIndex = getLastIndex(arr, num, 0, arr.length - 1);

        int count = 0;
        if(leftIndex > -1 && rightIndex > -1){
            count = rightIndex - leftIndex + 1;
        }

        return count;
    }

    private static int getFirstIndex(int[] arr, int num, int left, int right) {
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        if(arr[mid] > num){
            right = mid - 1;
        }else if(arr[mid] < num){
            left = mid + 1;
        }else{
            if(mid == 0 || (mid > 0 && arr[mid-1] != num)){
                return mid;
            }else{
                right = mid - 1;
            }
        }

        return getFirstIndex(arr, num, left, right);
    }

    private static int getLastIndex(int[] arr, int num, int left, int right) {
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        if(arr[mid] > num){
            right = mid - 1;
        }else if(arr[mid] < num){
            left = mid + 1;
        }else{
            if(mid == arr.length - 1 || (mid < arr.length - 1 && arr[mid+1] != num)){
                return mid;
            }else{
                left = mid + 1;
            }
        }

        return getLastIndex(arr, num, left, right);
    }
}
