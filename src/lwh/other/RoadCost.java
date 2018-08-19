package lwh.other;

import java.util.Arrays;
import java.util.Scanner;

public class RoadCost {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(getMinCost(arr));
        }
    }

    private static int getMinCost(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        Arrays.sort(arr);

        int minCost = 0;
        for(int i = 1; i < arr.length; i++){
            minCost += arr[i];
        }

        return minCost;
    }
}
