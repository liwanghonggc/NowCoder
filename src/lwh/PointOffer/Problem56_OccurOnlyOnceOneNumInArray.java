package lwh.PointOffer;

/**
 * 数组中只出现一次的数字,在一个数组中除一个数字只出现一次外,其他数字都出现了3次
 **/
public class Problem56_OccurOnlyOnceOneNumInArray {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 3, 5, 3, 5};
        int num = getOnlyOnceNum(arr);
        System.out.println(num);
    }

    private static int getOnlyOnceNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int[] bitSum = new int[32];
        for (int i = 0; i < arr.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = arr[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }
}
