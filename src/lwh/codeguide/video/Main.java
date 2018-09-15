package lwh.codeguide.video;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            int[] num1 = new int[3];
            int[] num2 = new int[3];
            
            for (int i = 0; i < 3; i++) {
                num1[i] = ch[i] - '0';
            }
            for(int i = 0; i < 3; i++){
                num2[i] = ch[i + 3] - '0';
            }
           
            Arrays.sort(num1);
            Arrays.sort(num2);
            
            int sum1 = 0;
            int sum2 = 0;
            int temp = 0;
            int count = 0;
            
            for (int i = 0; i < num1.length; i++) {
                sum1 += num1[i];
            }
            for (int i = 0; i < num2.length; i++) {
                sum2 += num2[i];
            }
            
            if (sum1 == sum2) {
                System.out.println(0);
            } else if (sum1 > sum2) {
                temp = sum1 - sum2;
                count = help(temp, num2, num1);
                System.out.println(count);
            } else {
                temp = sum2 - sum1;
                count = help(temp, num1, num2);
                System.out.println(count);
            }
        }

    }

    public static int help(int temp, int[] arr1, int[] arr2) {
        int count = 0;
        int index1 = 0;
        int index2 = 2;
        while (true) {
            if (temp <= (9 - arr1[index1]) || temp <= arr2[index2]) {
                count++;
                break;
            } else {
                count++;
                if ((9 - arr1[index1]) > arr2[index2]) {
                    temp = temp - (9 - arr1[index1]);
                    index1++;
                } else {
                    temp = temp - arr2[index2--];
                }
            }
        }
        return count;
    }

}