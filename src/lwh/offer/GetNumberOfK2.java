package lwh.offer;

public class GetNumberOfK2 {

    public static void main(String[] args) {
        int[] array = {3, 3, 3, 4, 5, 5, 8, 8};
        System.out.println(GetNumberOfK(array, 8));
    }

    public static int GetNumberOfK(int[] array, int k) {
        int count = 0;

        if (array != null && array.length > 0) {
            int firstIndexOfK = GetFirstIndexOfK(array, k, 0, array.length - 1);
            int lastIndexOfK = GetLastIndexOfK(array, k, 0, array.length - 1);
            if (firstIndexOfK > -1 && lastIndexOfK > -1) {
                count = lastIndexOfK - firstIndexOfK + 1;
            }
        }

        return count;
    }

    private static int GetLastIndexOfK(int[] a, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (a[mid] == k) {
            if (mid == a.length - 1 || (mid < a.length - 1 && a[mid + 1] != k)) {
                return mid;
            }
            left = mid + 1;
        } else if (a[mid] > k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return GetLastIndexOfK(a, k, left, right);
    }

    private static int GetFirstIndexOfK(int[] a, int k, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (a[mid] == k) {
            if (mid == 0 || (mid > 0 && a[mid - 1] != k)) {
                return mid;
            }
            right = mid - 1;
        } else if (a[mid] > k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return GetFirstIndexOfK(a, k, left, right);
    }


}
