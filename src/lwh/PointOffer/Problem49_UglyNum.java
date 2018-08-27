package lwh.PointOffer;

public class Problem49_UglyNum {

    public static void main(String[] args) {
        System.out.println(getUglyNum(4));
    }

    private static int getUglyNum(int index){
        int[] help = new int[index];
        help[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        int i = 1;

        while(i < index){
            help[i] = Math.min(2 * help[i2], Math.min(3 * help[i3], 5 * help[i5]));
            if(help[i] == 2 * help[i2]){
                i2++;
            }
            if(help[i] == 3 * help[i3]){
                i3++;
            }
            if(help[i] == 5 * help[i5]){
                i5++;
            }
            i++;
        }

        return help[index-1];
    }
}
