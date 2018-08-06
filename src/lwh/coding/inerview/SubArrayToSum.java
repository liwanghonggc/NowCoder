package lwh.coding.inerview;

public class SubArrayToSum {

    public static void main(String[] args) {
        int[] arr = {1 , 4, 8};
        System.out.println(subArrayEqualToSum(arr, 14));
    }

    public static boolean subArrayEqualToSum(int[] a, int aim){
        return process(a, 0, 0, aim);
    }

    private static boolean process(int[] a, int i, int sum, int aim){
        if(sum == aim){
            return true;
        }
        if(i == a.length){
            return false;
        }
        return process(a, i + 1, sum, aim) || process(a, i + 1, sum + a[i], aim);
    }
}
