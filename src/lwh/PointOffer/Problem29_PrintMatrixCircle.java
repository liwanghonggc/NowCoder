package lwh.PointOffer;

public class Problem29_PrintMatrixCircle {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(arr);
    }

    private static void printMatrix(int[][] arr){
        if (arr == null || arr.length == 0 || arr[0].length == 0){
            return;
        }

        int tR = 0;
        int tC = 0;
        int dR = arr.length - 1;
        int dC = arr[0].length - 1;

        while(tR <= dR && dC <= dC){
            printEdge(arr, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        if(tR == dR){
            /** 子矩阵只有一行 **/
            for(int i = tC; i <= dC; i++){
                System.out.print(arr[tR][i] + ", ");
            }
        }else if(tC == dC){
            /** 子矩阵只有一列 **/
            for(int i = tR; i <= dR; i++){
                System.out.print(arr[i][tC] + ", ");
            }
        }else{
            int curC = tC;
            int curR = tR;

            while(curC != dC){
                System.out.print(arr[tR][curC] + ", ");
                curC++;
            }
            while(curR != dR){
                System.out.print(arr[curR][dC] + ", ");
                curR++;
            }
            while(curC != tC){
                System.out.print(arr[dR][curC] + ", ");
                curC--;
            }
            while(curR != tR){
                System.out.print(arr[curR][tC] + ", ");
                curR--;
            }
        }
    }
}
