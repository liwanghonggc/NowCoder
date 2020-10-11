package lwh.lcbytag.array;

import lwh.lcbytag.util.ArrayUtil;

/**
 * @author lwh
 * @date 2020-10-11
 * @desp 
 * 
 * 给定一个矩阵A, 返回A的转置矩阵.
 *
 * 矩阵的转置是指将矩阵的主对角线翻转, 交换矩阵的行索引与列索引.
 *
 * 示例 1:
 *
 * 输入:[[1,2,3],
 *      [4,5,6],
 *      [7,8,9]]
 *
 * 输出:[[1,4,7],
 *      [2,5,8],
 *      [3,6,9]]
 *
 * 示例 2:
 *
 * 输入:[[1,2,3],
 *      [4,5,6]]
 *
 * 输出:[[1,4],
 *      [2,5],
 *      [3,6]]
 *  
 *
 * 提示:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 *
 * 来源:力扣(LeetCode)
 * 链接:https://leetcode-cn.com/problems/transpose-matrix
 */
public class Problem_867_TransposeMatrix_Easy_Pass_1 {

    public static void main(String[] args) {
        int[][] A = new int[2][3];

        int h = A.length, l = A[0].length;
        int index = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                A[i][j] = index++;
            }
        }


        ArrayUtil.printMatrix(A);

        ArrayUtil.printMatrix(transpose(A));
    }

    public static int[][] transpose(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }

        int h = A.length, l = A[0].length;
        int[][] r = new int[l][h];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < h; j++) {
                r[i][j] = A[j][i];
            }
        }

        return r;
    }
}
