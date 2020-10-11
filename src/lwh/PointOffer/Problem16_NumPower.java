package lwh.PointOffer;

/**
 * @author lwh
 * @date 2018-09-17
 * @desp
 */
public class Problem16_NumPower {

    public static void main(String[] args) {
        System.out.println(power(2, -1));
    }


    private static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        int n = Math.abs(exponent);
        double result = power(base, n >> 1);
        result *= result;

        if ((n & 1) == 1) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

}
