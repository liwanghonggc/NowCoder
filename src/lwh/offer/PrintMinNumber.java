package lwh.offer;

public class PrintMinNumber {

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        System.out.println(PrintMinNumber(numbers));


    }

    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        QuickSort(numbers, 0, numbers.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {
            sb.append(i);
        }

        return sb.toString();
    }

    private static void QuickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(a, left, right);
        QuickSort(a, left, pivotIndex - 1);
        QuickSort(a, pivotIndex + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int less = left - 1;
        for (int i = left; i < right; i++) {
            if (AIsSmallThanB(a[i], pivot)) {
                swap(a, ++less, i);
            }
        }
        swap(a, ++less, right);
        return less;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean AIsSmallThanB(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);

        String c = aStr + bStr;
        String d = bStr + aStr;

        int res = c.compareTo(d);
        if (res <= 0) {
            return true;
        }
        return false;
    }

}
