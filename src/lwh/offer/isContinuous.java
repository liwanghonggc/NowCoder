package lwh.offer;

import java.util.Arrays;

public class isContinuous {

    public static void main(String[] args) {
        int[] numbers = {0, 2, 1, 3, 5};
        System.out.println(isContinuous(numbers));
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }

        Arrays.sort(numbers);

        int zeroCount = 0;
        int nextIndex = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){
                zeroCount++;
            }else{
                nextIndex = i;
                break;
            }
        }

        for(int i = nextIndex + 1; i < numbers.length; i++){
            int diff = numbers[i] - numbers[i-1];
            if(diff == 0){
                return false;
            }else if(diff == 1){
                continue;
            }else{
                zeroCount -= (diff - 1);
                if(zeroCount < 0){
                    return false;
                }
            }
        }

        return true;
    }
}
