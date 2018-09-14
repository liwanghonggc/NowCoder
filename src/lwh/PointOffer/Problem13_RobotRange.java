package lwh.PointOffer;

/**
 * @author lwh
 * @date 2018-09-14
 * @desp 机器人的运动范围
 */
public class Problem13_RobotRange {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 4, 4));
    }

    public static int movingCount(int threshold, int rows, int cols){
        boolean[][] flag = new boolean[rows][cols];
        int count = doMoveCount(threshold, rows, cols, 0, 0, flag);
        return count;
    }

    private static int doMoveCount(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
        int count = 0;
        if(checkNum(threshold, rows, cols, i, j, flag)){
            flag[i][j] = true;
            count = 1 + doMoveCount(threshold, rows, cols, i + 1, j, flag)
                      + doMoveCount(threshold, rows, cols, i - 1, j, flag)
                      + doMoveCount(threshold, rows, cols, i, j - 1, flag)
                      + doMoveCount(threshold, rows, cols, i, j + 1, flag);
        }

        return count;
    }

    private static boolean checkNum(int threshold, int rows, int cols, int i, int j, boolean[][] flag) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j]){
            return false;
        }

        int sum = getDigitSum(i) + getDigitSum(j);
        if(sum > threshold){
            return false;
        }
        return true;
    }

    private static int getDigitSum(int i) {
        int digitSum = 0;
        while(i > 0){
            digitSum += i % 10;
            i = i / 10;
        }
        return digitSum;
    }
}
