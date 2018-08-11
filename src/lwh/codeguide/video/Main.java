package lwh.codeguide.video;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
        	String str = sc.nextLine();
        	char[] chs = str.toCharArray();
        	char a = chs[0];
        	char b = chs[1];
        	char c = chs[2];
        	char d = chs[3];
        	
        	int count = 0;
        	if((a == b && c == d) || (a == c && b == d) || (a == d && b == c)){
        		count++;
        	}
        	System.out.println(count);
        }
    }
}
