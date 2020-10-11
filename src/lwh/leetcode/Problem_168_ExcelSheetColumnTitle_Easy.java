package lwh.leetcode;
/**
 *
 */
public class Problem_168_ExcelSheetColumnTitle_Easy {

    public static String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            char ch = (char) ((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            sb.append(ch);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
