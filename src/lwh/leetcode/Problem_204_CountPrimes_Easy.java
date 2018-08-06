package lwh.leetcode;

public class Problem_204_CountPrimes_Easy {

    public static int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int num){
        if(num == 2 || num == 3){
            return true;
        }

        //不在6的倍数两侧的一定不是质数
        if(num % 6 != 1 && num % 6 != 5){
            return false;
        }

        int temp = (int)Math.sqrt(num);

        //在6的倍数两侧的也可能不是质数
        for(int i = 5; i <= temp; i += 6){
            if(num % i == 0 || num % (i + 2) == 0){
                return false;
            }
        }

        //排除所有,就是质数
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1500000));
    }
}
