package lwh.PointOffer;

public class Problem53_FindIndexEqualNumInSortArray {

    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 3, 5};
        int index = findIndex(arr);
        System.out.println(index);
    }

    private static int findIndex(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] == mid){
                return mid;
            }else if(arr[mid] > mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }
}
