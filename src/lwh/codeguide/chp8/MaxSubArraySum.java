package lwh.codeguide.chp8;

/**
 * 子数组的最大累加和
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(getMaxSum(arr));
    }

    private static int getMaxSum(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxSum = arr[0];
        int curSum = 0;

        for(int i = 0; i < arr.length; i++){
            curSum += arr[i];
            if(curSum > maxSum){
                maxSum = curSum;
            }
            if(curSum < 0){
                curSum = 0;
            }
        }

        return maxSum;
    }
}
