package lwh.leetcode;

public class Problem_242_ValidAnagram_Easy {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] a1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 97;
            a1[index]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 97;
            a1[index]--;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
