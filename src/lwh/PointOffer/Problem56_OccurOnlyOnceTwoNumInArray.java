package lwh.PointOffer;

/**
 * 数组中仅出现一次的两个数字,一个整形数组里除了两个数字之外,其他数字都出现了两次
 **/

/** 异或性质：任何一个数字异或它等于自己 **/
public class Problem56_OccurOnlyOnceTwoNumInArray {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] res = getRes(arr);
        System.out.println(res[0] + ", " + res[1]);
    }

    private static int[] getRes(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        /** 返回结果**/
        int[] res = new int[2];

        /** 计算所有数的相与结果pro **/
        int pro = 0;
        for (int i = 0; i < arr.length; i++) {
            pro ^= arr[i];
        }

        /** 计算pro第一个不为0的index,根据该index将数组划分为两个部分**/
        int index = findFirstIndex(pro);
        for (int i = 0; i < arr.length; i++) {
            /** 判断元素arr[i]第index位是否为1 **/
            if (isBitOne(arr[i], index)) {
                res[0] ^= arr[i];
            } else {
                res[1] ^= arr[i];
            }
        }

        return res;
    }

    /** 计算pro第一个不为0的index,根据该index将数组划分为两个部分**/
    private static int findFirstIndex(int pro) {
        int index = 0;
        while ((pro & 1) == 0) {
            index++;
            pro = pro >> 1;
        }
        return index;
    }

    /** 判断元素arr[i]第index位是否为1 **/
    private static boolean isBitOne(int num, int index) {
        num = num >> index;
        num = num & 1;
        if (num == 0) {
            return false;
        }
        return true;
    }
}
