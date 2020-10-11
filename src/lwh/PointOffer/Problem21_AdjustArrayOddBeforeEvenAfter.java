package lwh.PointOffer;

import java.util.Arrays;

/**
 * 调整数组顺序使得奇数位于偶数前面
 **/
public class Problem21_AdjustArrayOddBeforeEvenAfter {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        adjustArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void adjustArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            /** 向后移动i,直到它指向偶数 **/
            while (i < j && arr[i] % 2 != 0) {
                i++;
            }

            /** 向前移动j,直到它指向奇数 **/
            while (i < j && arr[j] % 2 == 0) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
