package lwh.PointOffer;

public class Problem11_RotateArray {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int min = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                min = array[i + 1];
                break;
            }
        }

        return min;
    }
}
