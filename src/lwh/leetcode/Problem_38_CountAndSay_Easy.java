package lwh.leetcode;

public class Problem_38_CountAndSay_Easy {

    public static String countAndSay(int n) {
        if(n <= 0){
            return "";
        }

        String[] strs = new String[n+1];
        strs[0] = "";
        strs[1] = "1";

        for (int i = 2; i <= n; i++){
            String pre = strs[i-1];
            char[] chs = pre.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chs.length;){
                int count = 1;
                int k = 0;
                for (k = j + 1; k < chs.length; k++){
                    if(chs[j] == chs[k]){
                        count++;
                    }else{
                        break;
                    }
                }
                sb.append(count + "" + chs[j]);
                j = k;
            }
            strs[i] = sb.toString();
        }
        return strs[n];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
