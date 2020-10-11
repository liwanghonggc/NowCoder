package lwh.offer;

public class UglyNumber2 {

    public static void main(String[] args) {

        System.out.println(GetUglyNumber_Solution(4));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index) {
            int min = min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[p2] * 2 <= min) {
                p2++;
            }
            while (uglyNumbers[p3] * 3 <= min) {
                p3++;
            }
            while (uglyNumbers[p5] * 5 <= min) {
                p5++;
            }
            nextUglyIndex++;
        }
        return uglyNumbers[index - 1];
    }

    private static int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

}
