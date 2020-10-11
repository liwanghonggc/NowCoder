package lwh.PointOffer;

public class Problem10_Fibonaqi {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFibonaci(n));
    }

    private static int getFibonaci(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);

        return res[0][0] + res[1][0];
    }

    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];

        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        int[][] tmp = m;

        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = matrixMultiply(res, tmp);
            }
            tmp = matrixMultiply(tmp, tmp);
        }

        return res;
    }

    private static int[][] matrixMultiply(int[][] p, int[][] q) {
        int[][] res = new int[p.length][q[0].length];

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < q[0].length; j++) {
                for (int k = 0; k < q.length; k++) {
                    res[i][j] += p[i][k] * q[k][j];
                }
            }
        }

        return res;
    }
}
