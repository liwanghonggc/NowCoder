package lwh.offer;

import java.util.ArrayList;

public class FindContinuousSequence {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(100);
        for (ArrayList<Integer> tmp : res) {
            System.out.println(tmp);
        }
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (sum < 3) {
            return list;
        }

        int small = 1;
        int big = 2;
        int mid = (sum + 1) / 2;
        int curSum = small + big;

        while (small < mid) {
            if (curSum == sum) {
                addNumtoList(small, big, list);
            }

            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;

                if (curSum == sum) {
                    addNumtoList(small, big, list);
                }
            }

            big++;
            curSum += big;
        }

        return list;
    }

    private static void addNumtoList(int small, int big, ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            temp.add(i);
        }
        list.add(temp);
    }
}
