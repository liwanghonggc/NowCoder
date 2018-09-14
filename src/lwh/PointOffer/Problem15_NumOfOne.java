package lwh.PointOffer;

/**
 * @author lwh
 * @date 2018-09-14
 * @desp 二进制中1的个数
 */
public class Problem15_NumOfOne {

    public static void main(String[] args) {
        int num = 9;
        System.out.println(numOfOne(num));
    }

    private static int numOfOne(int num) {
        int count = 0;
        while (num > 0){
            if((num & 1) == 1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
