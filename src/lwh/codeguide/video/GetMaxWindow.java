package lwh.codeguide.video;

/**
 * 生成滑动窗口最大值
 *
 * @author lwh
 */
public class GetMaxWindow {

    //复杂度O(n*w)
    public static void getMaxArray(int[] a, int w) {
        int n = a.length;
        int[] r = new int[n - w + 1];
        for (int i = 0; i < r.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j <= i + w - 1; j++) {
                if (a[j] > max) {
                    max = a[j];
                }
            }
            r[i] = max;
        }

        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        getMaxArray(a, w);
    }

}
