package lwh.codeguide.chp8;

import java.util.Arrays;

public class PartitionSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        incrSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给定一个数组,只含0,1,2,给其排序
     * 另一种问法,有一个数组,只含红黄蓝三种球,将其排序
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = -1;
        int right = arr.length;
        int index = 0;

        while (index < right) {
            if (arr[index] == 0) {
                swap(arr, ++left, index++);
            } else if (arr[index] == 2) {
                swap(arr, index, --right);
            } else {
                index++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 数组左半部分没有重复且有序,右半部分不保证
     *
     * @param arr
     */
    private static void incrSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int u = 0;
        int i = 1;
        while (i != arr.length) {
            if (arr[i] != arr[u]) {
                swap(arr, ++u, i);
            }
            i++;
        }
    }
}
