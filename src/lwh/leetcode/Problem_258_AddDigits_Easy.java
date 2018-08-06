package lwh.leetcode;

public class Problem_258_AddDigits_Easy {

    public static int addDigits(int num) {
        if(num < 0){
            return -1;
        }

        while(String.valueOf(num).length() > 1){
            num = getAllDigitsSum(num);
        }
        return num;
    }

    private static int getAllDigitsSum(int num){
        int sum = 0;
        while(num > 0){
            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }

    private static int addDigits_2(int num){
        if(num % 9 == 0){
            return num == 0 ? 0 : 9;
        }
        return num % 9;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(32));
    }
}
