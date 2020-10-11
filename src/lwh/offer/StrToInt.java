package lwh.offer;

public class StrToInt {

    public static void main(String[] args) {
        System.out.println(StrToInt("+21a7483647"));
    }

    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int res = 0;
        int r = 1;
        char[] chs = str.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] > '0' && chs[i] < '9') {
                res += (chs[i] - 48) * r;
                r *= 10;
            } else if (chs[i] == '+' || chs[i] == '-') {
                continue;
            } else {
                return 0;
            }
        }
        if (str.startsWith("-")) {
            return 0 - res;
        }
        return res;
    }
}
