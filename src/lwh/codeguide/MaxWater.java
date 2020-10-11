package lwh.codeguide;

import java.util.Arrays;

public class MaxWater {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 8, 6, 9};
        System.out.println(getMaxWater(a));
    }

    public static int getMaxWater(int[] a) {
        if (a == null || a.length < 3) {
            return 0;
        }

        int[] maxArrayLeft = new int[a.length];
        maxArrayLeft[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            maxArrayLeft[i] = a[i] > maxArrayLeft[i - 1] ? a[i] : maxArrayLeft[i - 1];
        }

        int[] maxArrayRight = new int[a.length];
        maxArrayRight[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            maxArrayRight[i] = a[i] > maxArrayRight[i + 1] ? a[i] : maxArrayRight[i + 1];
        }

        System.out.println(Arrays.toString(maxArrayLeft));
        System.out.println(Arrays.toString(maxArrayRight));

        int sum = 0;
        for (int i = 1; i < a.length - 1; i++) {
            int maxLeft = maxArrayLeft[i - 1];
            int maxRight = maxArrayRight[i + 1];
            int diff = Math.min(maxLeft, maxRight) - a[i];
            int maxWaterOfIndexI = diff < 0 ? 0 : diff;
            sum += maxWaterOfIndexI;
        }
        return sum;
    }
}
