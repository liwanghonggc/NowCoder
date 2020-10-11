package lwh.offer;

public class InversePairs {

    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        System.out.println(InversePairs(array));
    }

    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return mergeSortRecursion(array, 0, array.length - 1);

    }

    private static int mergeSortRecursion(int[] array, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int left = mergeSortRecursion(array, l, mid) % 1000000007;
        int right = mergeSortRecursion(array, mid + 1, r) % 1000000007;
        return (left + right + merge(array, l, mid, r)) % 1000000007;
    }

    private static int merge(int[] a, int l, int mid, int r) {
        int len = r - l + 1;
        int[] temp = new int[len];
        int index = 0;
        int i = l;
        int j = mid + 1;
        int reverseNum = 0;

        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                temp[index++] = a[i++];
            } else {
                temp[index++] = a[j++];
                reverseNum += (mid - i + 1);
                if (reverseNum > 1000000007) {
                    reverseNum %= 1000000007;
                }
            }
        }
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= r) {
            temp[index++] = a[j++];
        }

        for (int k = 0; k < len; k++) {
            a[l++] = temp[k];
        }
        return reverseNum;
    }

}
