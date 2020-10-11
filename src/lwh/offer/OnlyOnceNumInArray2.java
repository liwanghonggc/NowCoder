package lwh.offer;

public class OnlyOnceNumInArray2 {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 2, 4, 4, 5, 7, 7};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + ", " + num2[0]);
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        //对数组所有元素异或
        int exclusiveOrResult = 0;
        for (int i = 0; i < array.length; i++) {
            exclusiveOrResult ^= array[i];
        }

        int indexOfFirst1 = findIndexOfFirst1(exclusiveOrResult);
        for (int i = 0; i < array.length; i++) {
            if (isOneIndex(array[i], indexOfFirst1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    //找出异或结果右边第一位不是1的index
    private static int findIndexOfFirst1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    private static boolean isOneIndex(int num, int index) {
        num = num >> index;
        boolean flag = (num & 1) == 1 ? true : false;
        return flag;
    }

}
