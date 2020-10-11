package lwh.leetcode;

/**
 *
 */
public class Problem_58_LengthOfLastWord_Easy {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || "".equals(s.trim())) {
            return 0;
        }

        String[] strs = s.split(" ");
        int len = strs.length;
        return strs[len - 1].length();
    }

    public static void main(String[] args) {
        String s = "  ";
        System.out.println(lengthOfLastWord(s));
    }
}
