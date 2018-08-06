package lwh.coding.inerview;

public class FullPermutation {

    public static void printFullPermutation(String str){
        if(str == null || str.length() == 0){
            return;
        }
        char[] chs = str.toCharArray();
        fullPermutationRecursive(chs, 0);
    }

    public static void fullPermutationRecursive(char[] chs, int i){
        if(i == chs.length){
            System.out.println(new String(chs));
        }
        for(int j = i; j < chs.length; j++){
            swap(chs, i, j);
            fullPermutationRecursive(chs, i + 1);
            swap(chs, i, j);
        }
    }

    public static void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        printFullPermutation(str);
    }
}
