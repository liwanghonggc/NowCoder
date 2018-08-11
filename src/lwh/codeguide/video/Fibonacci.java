package lwh.codeguide.video;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(f(n));
		}
	}

	private static long f(int n) {
		if(n < 1){
			return 0;
		}
		if(n == 1 || n == 2){
			return 1;
		}
		long[][] base = {{1, 1}, {1, 0}};
		long[][] res = matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}

	private static long[][] matrixPower(long[][] m, int p) {
		long[][] res = new long[m.length][m[0].length];
		for(int i = 0; i < res.length; i++){
			res[i][i] = 1;
		}
		long[][] tmp = m;
		for(; p != 0; p >>= 1){
			if((p & 1) != 0){
				res = multiMatrix(res, tmp);
			}
			tmp = multiMatrix(tmp, tmp);
		}
		return res;
	}

	private static long[][] multiMatrix(long[][] m1, long[][] m2) {
		long[][] res = new long[m1.length][m2.length];
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
