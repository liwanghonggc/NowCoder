package lwh.codeguide.chp4;

/**
 * @author lwh
 * @date 2019-03-09
 * @desp
 */
public class Fibonaqi {

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(fibonaqi1(i) + ", " + fibonaqi2(i) + ", " + fibonaqi3(i));
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

    private static int fibonaqi3(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }

        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    private static int[][] matrixPower(int[][] m, int p){
        int[][] res = new int[m.length][m[0].length];
        for(int i = 0; i < m.length; i++){
            res[i][i] = 1;
        }

        int[][] tmp = m;
        for(; p != 0; p >>= 1){
            if((p & 1) != 0){
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }

        return res;
    }

    private static int[][] multiMatrix(int[][] m1, int[][] m2){
        int[][] res = new int[m1.length][m2[0].length];
        for(int i = 0; i < m1.length; i++){
            for(int j = 0; j < m2[0].length; j++){
                for(int k = 0; k < m2.length; k++){
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        return res;
    }
}
