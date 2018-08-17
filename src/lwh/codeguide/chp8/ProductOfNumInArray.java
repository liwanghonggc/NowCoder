package lwh.codeguide.chp8;

import java.util.Arrays;

public class ProductOfNumInArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        int[] res = product1(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] product1(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        int count = 0;
        int allPro = 1;
        int[] res = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != i){
                allPro *= arr[i];
            }else{
                count++;
            }
        }

        if(count == 0){
            for(int i = 0; i < arr.length; i++){
                res[i] = allPro / arr[i];
            }
        }

        if(count == 1){
            for(int i = 0; i < arr.length; i++){
                if(arr[i] != 0){
                    res[i] = allPro;
                }
            }
        }

        return res;
    }
}
