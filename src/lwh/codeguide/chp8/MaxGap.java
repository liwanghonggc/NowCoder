package lwh.codeguide.chp8;

public class MaxGap {

    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 10};
        System.out.println(getMaxGap(arr));
    }

    private static int getMaxGap(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++){
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        if(min == max){
            return 0;
        }

        boolean[] hasNum = new boolean[len+1];
        int[] maxs = new int[len+1];
        int[] mins = new int[len+1];

        int bid = 0;
        for(int i = 0; i < len; i++){
            bid = getBucket(arr[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(arr[i], maxs[bid]) : arr[i];
            hasNum[bid] = true;
        }

        int i = 0;
        int lastMax = 0;
        int res = 0;

        for(; i <= len; i++){
            if(hasNum[i]){
                lastMax = maxs[i];
            }else{
                break;
            }
        }

        for(; i <= len; i++){
            if(hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    private static int getBucket(long num, long len, long min, long max) {
        return (int)((num - min) * len / (max - min));
    }
}
