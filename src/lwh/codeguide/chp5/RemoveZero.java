package lwh.codeguide.chp5;

import java.util.Scanner;

public class RemoveZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int k = Integer.valueOf(sc.nextLine());

            String res = getRemoveStr(str, k);

            System.out.println(res);
        }
    }

    private static String getRemoveStr(String str, int k) {
        if(str == null || str.length() == 0 || k <= 0){
            return str;
        }

        char[] ch = str.toCharArray();
        int count = 0, start = -1;

        for(int i = 0; i != ch.length; i++){
            if(ch[i] == '0'){
                count++;
                start = start == -1 ? i : start;
            }else{
                if(count == k){
                    while(count-- != 0){
                        ch[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }

        if(count == k){
            while(count-- != 0){
                ch[start++] = 0;
            }
        }

        return String.valueOf(ch);
    }


}
