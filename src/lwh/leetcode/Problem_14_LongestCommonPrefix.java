package lwh.leetcode;

public class Problem_14_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++){
            if(strs[i] == null || strs[i].length() == 0){
                return "";
            }
            if(strs[i].length() < minLen){
                minLen = strs[i].length();
            }
        }

        int i = 0;
        for (i = 0; i < minLen; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; i++){
                char temp = strs[j].charAt(i);
                if(temp != c){
                    String res = strs[0].substring(0, i);
                    if(res == null){
                        return "";
                    }else{
                        return res;
                    }
                }
            }
        }

        String res = strs[0].substring(0, i + 1);
        if(res == null){
            return "";
        }else{
            return res;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
