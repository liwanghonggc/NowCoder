package lwh.PointOffer;

public class Problem57_SumEqualToS2 {

    public static void main(String[] args) {
        getSeq(9);
    }

    private static void getSeq(int sum){
        if(sum < 3){
            return;
        }

        int small = 1;
        int big = 2;
        int mid = (sum + 1) / 2;
        int curSum = small + big;

        while(small < mid){
            if(curSum == sum){
                printSeq(small, big);
            }

            /** 大于的话将small向右移动,big不变 **/
            while(curSum > sum && small < mid){
                curSum -= small;
                small++;

                if(curSum == sum){
                    printSeq(small, big);
                }
            }

            /** 否则将big向右移动,small不变 **/
            big++;
            curSum += big;
        }
    }

    private static void printSeq(int small, int big) {
        for(int i = small; i <= big; i++){
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
