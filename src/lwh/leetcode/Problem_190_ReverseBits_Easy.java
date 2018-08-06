package lwh.leetcode;

public class Problem_190_ReverseBits_Easy {

    public static int reverseBits(int n) {
        int count = 0;
        while(n > 0){
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(11));
    }
}
