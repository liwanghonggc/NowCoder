package lwh.codeguide.chp8;

/**
 * @author lwh
 * @date 2018-09-15
 * @desp
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int p = Integer.parseInt(str[2]);
            
            String[] line = sc.nextLine().split(" ");
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            for (int j = 0; j < M; j++) {
                String[] s3 = sc.nextLine().split(" ");
                help(arr, s3[0], Integer.parseInt(s3[1]));
            }
            int count = 1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > arr[p - 1]) {
                    count++;
                }
            }
            System.out.println(count);

        }

    }

    public static void help(int[] arr, String s, int p) {
        if (s.equals("A")) {
            arr[p - 1] = arr[p - 1] + 1;
        } else if (s.equals("B")) {
            arr[p - 1] = arr[p - 1] - 1;
        }

    }
}
