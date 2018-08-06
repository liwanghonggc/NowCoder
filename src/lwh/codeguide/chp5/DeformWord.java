package lwh.codeguide.chp5;

import java.util.Scanner;

public class DeformWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();

            System.out.println(isDeformWord(str1, str2));
        }
    }

    private static boolean isDeformWord(String str1, String str2){
        if(str1 == null && str2 == null){
            return true;
        }

        if((str1 == null && str2 != null) || (str1 != null && str2 == null)){
            return false;
        }

        int[] map = new int[256];
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        for(int i = 0; i < ch1.length; i++){
            map[ch1[i]]++;
        }

        for(int i = 0; i < ch2.length; i++){
            map[ch2[i]]--;
        }

        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                return false;
            }
        }

        return true;
    }

}
