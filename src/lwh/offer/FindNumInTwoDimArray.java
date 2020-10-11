package lwh.offer;

public class FindNumInTwoDimArray {

    public static void main(String[] args) {
        int[][] a = {{}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Find(14, a));
    }

    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            int[] temp = array[i];
            int n = temp.length - 1;
            if (n >= 0 && target >= temp[0] && target <= temp[n]) {
                boolean flag = findNum(target, temp, 0, n);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findNum(int target, int[] temp, int left, int right) {
        int mid = (left + right) / 2;
        while (left <= right) {
            if (target < temp[mid]) {
                return findNum(target, temp, left, mid - 1);
            } else if (target > temp[mid]) {
                return findNum(target, temp, mid + 1, right);
            } else {
                return true;
            }
        }
        return false;
    }

}
