package lwh.leetcode;

import java.util.Scanner;

/**
 * 判断一个整数是否是回文数
 */
public class Problem_9_PalindromeNumber_Easy {

    public static boolean isPalindrome_1(int x) {
        if(x < 0){
            return false;
        }

        char[] chs = String.valueOf(x).toCharArray();
        int i = 0;
        int j = chs.length - 1;

        while(i < j){
            if(chs[i] == chs[j]){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome_2(int x) {
        if(x < 0){
            return false;
        }

        int index = 1;
        int num = x;
        while(num >= 10){
            index *= 10;
            num /= 10;
        }

        while(x != 0){
            int left = x / index;
            int right = x % 10;
            if(left != right){
                return false;
            }else{
                x = x % index;
                x = x / 10;
                index /= 100;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt();
            System.out.println(isPalindrome_2(x));
        }
    }
}
