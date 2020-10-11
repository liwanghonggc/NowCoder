package lwh.lcbytag.util;

import java.util.Arrays;

/**
 * @author lwh
 * @date 2020-10-11
 * @desp
 */
public class ArrayUtil {

    public static void printMatrix(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            System.out.println("A is Empty");
            return;
        }

        int l = A[0].length, h = A.length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(A[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] nums, int newLen) {
        if (nums == null || nums.length < 1) {
            System.out.println("Array is Empty");
        }


        if (nums.length < newLen) {
            System.out.println("newLen larger than nums length");
        }

        for (int i = 0; i < newLen; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i < newLen - 1) {
                System.out.print(nums[i] + ", ");
            } else {
                System.out.print(nums[i]);
            }

            if (i == newLen - 1) {
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2, 3};
        int[] c = {4, 5, 6};

        printArray(a, a.length);
        printArray(b, b.length);
        printArray(c, c.length);
    }
}
