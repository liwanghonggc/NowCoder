package lwh.leetcode;

import java.util.Scanner;

public class problem_191_NumberOf1Bits_Easy {

    public static int hammingWeight(long n) {
        int count = 0;
        int mask = 1;
        for(int i = 0; i < 64; i++){
            if((n & mask) != 0){
                count++;
            }
            mask <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long n = sc.nextLong();
            int count = 0;
            while (n != 0){
                count++;
                n = n & (n - 1);
            }
            System.out.println(count);
        }
    }
}
