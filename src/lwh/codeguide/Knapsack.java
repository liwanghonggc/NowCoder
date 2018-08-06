package lwh.codeguide;

public class Knapsack {

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;

        System.out.println(getMaxValue(c, p, bag));
    }

    public static int getMaxValue(int[] c, int[] p, int bag){
        return process1(c, p, 0, 0, bag);
    }

    public static int process1(int[] c, int[] p, int i, int alreadyWeight, int bag){
        if(alreadyWeight > bag){
            return Integer.MIN_VALUE;
        }
        if(i == p.length){
            return 0;
        }
        return Math.max(process1(c, p, i + 1, alreadyWeight, bag), p[i] + process1(c, p, i + 1, c[i] + alreadyWeight, bag));
    }
}
