package lwh.PointOffer;

/** 找到字符串的最长无重复子串 **/
public class Problem48_MaxLenUniqueCharSeq {

    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(maxUnique(str));
    }

    private static int maxUnique(String str){
        if(str == null || str.length() == 0){
            return 0;
        }

        char[] chs = str.toCharArray();
        int[] map = new int[256];
        for(int i = 0; i < 256; i++){
            map[i] = -1;
        }

        int len = 0;
        int pre = -1;
        int cur = 0;

        for(int i = 0; i < chs.length; i++){
            pre = Math.max(pre, map[chs[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chs[i]] = i;
        }

        return len;
    }
}
