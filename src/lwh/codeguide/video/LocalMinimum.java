package lwh.codeguide.video;

public class LocalMinimum {

    public static int getLocalMinIndex(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1 || a[0] < a[1]) {
            return 0;
        }
        int n = a.length;
        if (a[n - 1] < a[n - 2]) {
            return n - 1;
        }

        int[] c = new int[n - 1];
        System.arraycopy(a, 0, c, 0, n - 1);
        return getLocalMinIndex(c);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 8, 9, 10, 11, 12, 13};
        System.out.println(getLocalMinIndex(a));
    }

}
