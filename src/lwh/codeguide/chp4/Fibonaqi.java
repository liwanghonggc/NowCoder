package lwh.codeguide.chp4;

/**
 * @author lwh
 * @date 2019-03-09
 * @desp
 */
public class Fibonaqi {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(fibonaqi1(i) + ", " + fibonaqi2(i));
        }
    }

    private static int fibonaqi1(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonaqi1(n - 1) + fibonaqi1(n - 2);
    }

    private static int fibonaqi2(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int pre = 1;
        int p = 1;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = pre + p;
            pre = p;
            p = res;
        }
        return res;
    }
}
