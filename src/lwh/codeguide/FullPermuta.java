package lwh.codeguide;


import static lwh.codeguide.FullPermutation.swap;

/**
 * @author lwh
 * @date 2019-03-05
 * @desp
 */
public class FullPermuta {

    public static void main(String[] args) {
        String str = "ab";
        printFull(str);
    }

    private static void printFull(String str){
        if(str == null || str.length() == 0){
            return;
        }
        char[] chs = str.toCharArray();
        printFullRecur(chs, 0);
    }

    private static void printFullRecur(char[] chs, int i) {
        if(i == chs.length){
            System.out.println(new String(chs));
        }else{
            for(int j = i; j < chs.length; j++){
                swap(chs, i, j);
                printFullRecur(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }
}
