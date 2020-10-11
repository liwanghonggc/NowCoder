package lwh.leetcode;

/**
 *
 */
public class Problem_125_ValidPalindrome_Easy {

    public static boolean isPalindrome(String s) {
        if (s == null || "".equals(s.trim())) {
            return true;
        }

        char[] chs = s.toLowerCase().toCharArray();
        for (int i = 0, j = chs.length - 1; i < j; ) {
            if (!checkRange(chs[i])) {
                i++;
                continue;
            }
            if (!checkRange(chs[j])) {
                j--;
                continue;
            }
            if (chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean checkRange(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
