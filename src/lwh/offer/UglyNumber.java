package lwh.offer;

public class UglyNumber {

    public static void main(String[] args) {

        System.out.println(GetUglyNumber_Solution(4));
    }

    public static int GetUglyNumber_Solution(int index) {

        int count = 0;
        int i = 0;
        while (count < index) {
            i++;
            if (isUglyNum(i)) {
                count++;
            }
        }
        return i;
    }

    private static boolean isUglyNum(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1 ? true : false;
    }

}
