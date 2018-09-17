package lwh.offer;

import java.util.Arrays;

/**
 * @author lwh
 * @date 2018-09-17
 * @desp 打印从1到最大的n位数
 */
public class Print1ToN {

    public static void main(String[] args) {
        int num = 2;
        printMax(num);
    }

    private static void printMax(int num) {
        if(num <= 0){
            return;
        }
        char[] chs = new char[num];
        Arrays.fill(chs, '0');
        printRecur(chs, 0, num);
    }

    private static void printRecur(char[] chs, int loc, int len) {
        if(loc == len){
            return;
        }
        for(int i = 0; i <= 9; i++){
            chs[loc] = (char)('0' + i);
            if(loc == len - 1){
                printChar(chs);
            }
            printRecur(chs, loc + 1, len);
        }
    }

    private static void printChar(char[] chs) {
        int i = 0;
        for( ; i < chs.length; i++){
            if(chs[i] != '0'){
                break;
            }
        }
        if(i == chs.length){
            return;
        }
        for(int j = i; j < chs.length; j++){
            System.out.print(chs[j]);
        }
        System.out.println();
    }
}
