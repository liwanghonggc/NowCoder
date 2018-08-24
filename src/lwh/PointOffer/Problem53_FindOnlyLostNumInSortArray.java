package lwh.PointOffer;

/** 在0-n-1中查找唯一缺失的数字 **/
public class Problem53_FindOnlyLostNumInSortArray {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5};
        int index = findOnlyLostNum(arr);
        System.out.println(index);
    }

    private static int findOnlyLostNum(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        }

        int index = getIndexRecur(arr, 0, arr.length - 1);
        return index;
    }

    private static int getIndexRecur(int[] arr, int left, int right) {
        if(left > right){
            return -1;
        }

        int mid = (left + right) / 2;
        if(arr[mid] == mid){
            left = mid + 1;
        }else{
            if(mid == 0 || arr[mid-1] == mid - 1){
                return mid;
            }else{
                right = mid - 1;
            }
        }

        return getIndexRecur(arr, left, right);
    }
}
