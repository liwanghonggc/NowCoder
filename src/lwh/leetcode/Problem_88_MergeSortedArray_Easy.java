package lwh.leetcode;

import java.util.Arrays;

public class Problem_88_MergeSortedArray_Easy {

    public static void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int i = 0, j = 0;
        int k = 0;
        while (i < m && j < n) {
            temp[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }

        System.arraycopy(temp, 0, nums1, 0, nums1.length);
    }


    public static void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge_2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
