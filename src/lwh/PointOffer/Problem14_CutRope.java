package lwh.PointOffer;

/**
 * @author lwh
 * @date 2018-09-14
 * @desp
 */
public class Problem14_CutRope {

    public static void main(String[] args) {
        int len = 8;
        System.out.println(getMaxMulti(len));
    }

    private static int getMaxMulti(int len) {
        if(len < 2){
            return 0;
        }
        if(len < 4){
            return len - 1;
        }

        //尽可能减长度为3的绳子
        int timesOf3 = len / 3;

        //当绳子长度为4时,应该减长度为2和2的,而不是1,3
        if(len - timesOf3 * 3 == 1){
            timesOf3 -= 1;
        }

        int timesOf2 = (len - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

}
