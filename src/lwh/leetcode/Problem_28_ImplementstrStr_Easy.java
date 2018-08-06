package lwh.leetcode;

public class Problem_28_ImplementstrStr_Easy {

    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;

        int len = needle.length();
        int i = 0;
        for (i = 0; i + len <= haystack.length(); i++){
            String str = haystack.substring(i, i + len);
            if(needle.equals(str)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ello"));
    }
}
