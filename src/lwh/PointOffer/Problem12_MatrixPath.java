package lwh.PointOffer;

/**
 * @author lwh
 * @date 2018-09-14
 * @desp 矩阵中的路径
 */
public class Problem12_MatrixPath {

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e','h'}};
        char[] str = "acjd".toCharArray();
        System.out.println(hasPath(matrix, matrix.length, matrix[0].length, str));
    }

    private static boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
        //标记该位置是否已经在路径中,默认false
        boolean[][] flag = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(helper(matrix, rows, cols, i, j, str, 0, flag)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] matrix, int rows, int cols, int i, int j, char[] str, int k, boolean[][] flag) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[i][j] != str[k] || flag[i][j]){
            return false;
        }
        if(k == str.length - 1){
            return true;
        }
        flag[i][j] = true;
        if(helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)){
            return true;
        }
        flag[i][j] = false;
        return false;
    }
}
