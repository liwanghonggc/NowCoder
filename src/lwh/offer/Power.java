package lwh.offer;

/**
 * @author lwh
 * @date 2019-03-06
 * @desp 数值的整数次方
 */
public class Power {

    public static void main(String[] args) {
        System.out.println(power(2, 3));
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
