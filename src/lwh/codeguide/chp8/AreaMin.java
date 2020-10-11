package lwh.codeguide.chp8;

public class AreaMin {

    public static void main(String[] args) {

    }

    private static int getMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int len = arr.length;
        if (len == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[len - 1] < arr[len - 2]) {
            return len - 1;
        }

        int left = 1;
        int right = len - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
