package lwh.codeguide.chp5;

import java.util.Scanner;

public class ReplaceFromWithTo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String from = sc.nextLine();
            String to = sc.nextLine();

            System.out.println(replace(str, from, to));
        }

    }

    private static String replace(String str, String from, String to){
        if(str == null || from == null || str.length() == 0 || from.length() == 0){
            return str;
        }

        char[] chs = str.toCharArray();
        char[] chf = from.toCharArray();

        int match = 0;

        for(int i = 0; i < chs.length; i++){
            if(chs[i] == chf[match++]){
                if(match == chf.length){
                    clear(chs, i, chf.length);
                    match = 0;
                }
            }else{
                if(chs[i] == chf[0]){
                    i--;
                }
                match = 0;
            }
        }

        String res = "";
        String cur = "";

        for(int i = 0; i < chs.length; i++){
            if(chs[i] != 0){
                cur = cur + String.valueOf(chs[i]);
            }
            if(chs[i] == 0 && (i == 0 || chs[i-1] != 0)){
                res = res + cur + to;
                cur = "";
            }
        }

        if(!cur.equals("")){
            res = res + cur;
        }

        return res;
    }

    private static void clear(char[] chs, int end, int len){
        while(len-- != 0){
            chs[end--] = 0;
        }
    }
}
