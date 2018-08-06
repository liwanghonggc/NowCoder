package lwh.codeguide;

//打印一个字符串的所有子串,包括空串
public class PrintAllSubSequence {

    public static void printAllSubSeq(String str){
        if(str == null){
            return;
        }

        char[] chs = str.toCharArray();
        printSubSeqRecursive(chs, 0, "");
        System.out.println("");
    }

    //该递归表示i-1之前已经做好了决定,pre是做好的决定形成的子串
    public static void printSubSeqRecursive(char[] chs, int i, String pre){
        if(i == chs.length){
            if(!"".equals(pre)){
                System.out.println(pre);
            }
            return;
        }

        printSubSeqRecursive(chs, i + 1, pre + String.valueOf(chs[i]));
        printSubSeqRecursive(chs, i + 1, pre);
    }

    public static void main(String[] args) {
        String str = "abc";
        printAllSubSeq(str);
    }
}
