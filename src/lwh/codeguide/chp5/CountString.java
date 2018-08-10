package lwh.codeguide.chp5;

import java.util.Scanner;

public class CountString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            System.out.println(getCountString(str));
        }
    }

    private static String getCountString(String str) {
        if(str == null || str.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();

        if(chs.length == 1){
            return chs[0] + "_" + 1;
        }

        int count = 1;
        int len = chs.length;
        for(int i = 0; i < len - 1; i++){
            char temp = chs[i];
            if(chs[i] == chs[i+1]){
                count++;
            }else{
                if(i == len - 2){
                    if(chs[len-1] == chs[len-2]){
                        count++;
                        sb.append(temp + "_" + count);
                    }else{
                        sb.append(temp + "_" + count + "_");
                        sb.append(chs[len-1] + "_" + 1);
                    }
                }else{
                    sb.append(temp + "_" + count + "_");
                    count = 1;
                }
            }
        }

        return sb.toString();
    }
}
