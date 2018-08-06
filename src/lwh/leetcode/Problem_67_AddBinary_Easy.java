package lwh.leetcode;

public class Problem_67_AddBinary_Easy {

    public static String addBinary(String a, String b) {
        char[] chs1 = a.toCharArray();
        char[] chs2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = chs1.length - 1;
        int j = chs2.length - 1;
        int index = 0;
        int n1 = 0, n2 = 0;

        while(i >= 0 || j >= 0){
            n1 = (i >= 0) ? chs1[i] - 48 : 0;
            n2 = (j >= 0) ? chs2[j] - 48 : 0;

            int res = n1 + n2 + index;
            index = res / 2;
            res = res % 2;
            i--;
            j--;
            sb.append(res);
        }

        if(index != 0){
            sb.append(index);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
