package lwh.other;

/**
 * @author lwh
 * @date 2018-09-18
 * @desp 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 8, 9, 10, 12, 16};
        int num = 6;
        System.out.println(binarySearch1(arr, num));
        System.out.println(binarySearch2(arr, num));
    }

    /**
     * 递归的二分搜索
     *
     * @param arr
     * @param num
     * @return
     */
    private static int binarySearch1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return binarySearchRecur(arr, num, 0, arr.length - 1);
    }

    private static int binarySearchRecur(int[] arr, int num, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (num < arr[mid]) {
            return binarySearchRecur(arr, num, left, mid - 1);
        } else if (num == arr[mid]) {
            return mid;
        } else {
            return binarySearchRecur(arr, num, mid + 1, right);
        }
    }

    private static int binarySearch2(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (num < arr[mid]) {
                right = mid - 1;
            } else if (num == arr[mid]) {
                return mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
