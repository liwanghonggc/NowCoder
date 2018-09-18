package lwh.PointOffer;

/**
 * @author lwh
 * @date 2018-09-18
 * @desp 判断一个序列是不是二叉搜索树的后序遍历序列
 */
public class Problem33_VerifySeqOfBST {

    public static void main(String[] args) {
        int[] arr = {5, 7, 6, 9, 11, 10, 8};

        int[] a = {7, 4, 6, 5};
        System.out.println(isSeqOfBST(arr));
        System.out.println(isSeqOfBST(a));
    }

    private static boolean isSeqOfBST(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        return isSeqOfBSTRecur(arr, 0, arr.length - 1);
    }

    private static boolean isSeqOfBSTRecur(int[] arr, int left, int right) {
        if (left >= right) {
            return true;
        }

        int root = arr[right];

        int i = left;
        for (; i < right; i++) {
            if (arr[i] > root) {
                break;
            }
        }

        for (int j = i; j < right; j++) {
            if (arr[j] < root) {
                return false;
            }
        }

        return isSeqOfBSTRecur(arr, left, i - 1) && isSeqOfBSTRecur(arr, i, right - 1);

    }

}
