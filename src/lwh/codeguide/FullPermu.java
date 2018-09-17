package lwh.codeguide;

import static lwh.codeguide.FullPermutation.swap;

/**
 * @author lwh
 * @date 2018-09-17
 * @desp 全排列
 */
public class FullPermu {

    public static void main(String[] args) {
        String str = "abc";
        printFullPerm(str);
    }

    private static void printFullPerm(String str) {
        if(str == null || str.length() == 0){
            return;
        }
        char[] chs = str.toCharArray();
        printFullPermRecur(chs,0);
    }

    private static void printFullPermRecur(char[] chs, int i) {
        if(i == chs.length){
            System.out.println(new String(chs));
        }
        for(int j = i; j < chs.length; j++){
            swap(chs, i, j);
            printFullPermRecur(chs, i + 1);
            swap(chs, i, j);
        }
    }
}
