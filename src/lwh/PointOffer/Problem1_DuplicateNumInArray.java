package lwh.PointOffer;

public class Problem1_DuplicateNumInArray {

    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 1, 0, 1, 6, 5};
        int index = duplicate(arr);
        if (index == -1) {
            System.out.println("不存在重复数字");
        } else {
            System.out.println(arr[index]);
        }

    }

    /**
     * 返回重复数字的下标
     *
     * @param num
     * @return
     */
    public static int duplicate(int[] num) {
        if (num == null || num.length < 2) {
            return -1;
        }

        for (int i = 0; i < num.length; i++) {
            while (num[i] != i) {
                if (num[i] == num[num[i]]) {
                    return i;
                }
                int temp = num[i];
                num[i] = num[temp];
                num[temp] = temp;
            }
        }
        return -1;
    }

}
