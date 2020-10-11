package lwh.PointOffer;

public class Problem51_ReversePairsInArray {

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        System.out.println(getNumOfReversePairs(arr));
    }

    private static int getNumOfReversePairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        int count = inversePairs(arr, copy, 0, arr.length - 1);

        return count;
    }

    private static int inversePairs(int[] arr, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }

        int length = (end - start) / 2;

        int left = inversePairs(copy, arr, start, start + length);
        int right = inversePairs(copy, arr, start + length + 1, end);

        /** i初始化为前半段最后一个数字的下标 **/
        int i = start + length;
        /** j初始化为后半段最后一个数字的下标 **/
        int j = end;

        int indexCopy = end;

        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (arr[i] > arr[j]) {
                copy[indexCopy--] = arr[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = arr[j--];
            }
        }

        for (; i >= start; i--) {
            copy[indexCopy--] = arr[i];
        }

        for (; j >= start + length + 1; j--) {
            copy[indexCopy--] = arr[j];
        }

        return left + right + count;
    }
}
