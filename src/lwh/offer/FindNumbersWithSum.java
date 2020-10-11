package lwh.offer;

import java.util.ArrayList;

public class FindNumbersWithSum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 10;
        ArrayList<Integer> list = FindNumbersWithSum(array, sum);
        System.out.println(list);
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length < 1) {
            return list;
        }

        for (int i = 0, j = array.length - 1; i < j; ) {
            int curSum = array[i] + array[j];
            if (curSum == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (curSum < sum) {
                i++;
            } else {
                j--;
            }
        }

        return list;
    }

}
