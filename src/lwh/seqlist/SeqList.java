package lwh.seqlist;

import java.util.Arrays;

public class SeqList {

    private int maxLength = 10;
    private int[] a;
    private int size;

    public SeqList() {
    }

    public SeqList(int[] b) {
        a = b;
        size = a.length;
    }

    public SeqList(int maxLength) {
        this.maxLength = maxLength;
        a = new int[maxLength];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int length() {
        return size;
    }

    //将元素x插到下标i的元素之后
    boolean insert(int i, int x) {
        if (i < -1 || i > size - 1) {
            System.out.println("Insert out of Bounds");
            return false;
        }
        if (size == maxLength) {
            System.out.println("Overflow");
            return false;
        }
        for (int j = size - 1; j > i; j--) {
            a[j + 1] = a[j];
        }
        a[i + 1] = x;
        size++;
        return true;
    }

    //删除i下标的元素
    public boolean delete(int i) {
        if (i < 0 || i > size - 1) {
            System.out.println("Index out of Bound");
            return false;
        }
        if (size == 0) {
            System.out.println("No number to delete");
            return false;
        }
        for (int j = i; j <= size - 1; j++) {
            a[j] = a[j + 1];
        }
        size--;
        return true;
    }

    //按值查找第一个为x的元素下标
    public int find(int x) {
        for (int i = 0; i < size - 1; i++) {
            if (x == a[i])
                return i;
        }
        return -1;
    }

    //删除最小值(假设唯一)并返回该最小值,空出的位置由最后一个元素填补
    public int deleteMin() {
        if (size == 0) {
            System.out.println("No number to delete");
            return Integer.MAX_VALUE;
        }
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (a[i] < a[index]) {
                index = i;
            }
        }
        int min = a[index];
        a[index] = a[size - 1];
        size--;
        return min;
    }

    //逆置顺序表,要求空间复杂度O(1)
    public void reverse() {
        for (int i = 0; i <= (size - 1) / 2; i++) {
            int temp = a[i];
            a[i] = a[size - 1 - i];
            a[size - 1 - i] = temp;
        }
    }

    //删除所有值为x的元素,时间复杂度O(n)，空间复杂度O(1)
    //用k统计顺序表中不等于x的个数,边扫描边统计,并将不等于x的元素放到k位置上,最后修改顺序表长度为k
    public boolean deleteAllx1(int x) {
        if (size == 0) {
            System.out.println("No number to delete");
            return false;
        }
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] != x) {
                a[k] = a[i];
                k++;
            }
        }
        size = k;
        return true;
    }

    //删除有序顺序表中值在s与t之间的元素(s<t)
    public boolean deleteNums1(int s, int t) {
        if (size == 0) {
            System.out.println("No number to delete");
            return false;
        }
        if (s >= t) {
            System.out.println("Please input s <= t");
            return false;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] < s) {
                continue;
            } else {
                start = i;
                break;
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            if (a[i] > t) {
                continue;
            } else {
                end = i;
                break;
            }
        }
        int k = end - start + 1;
        for (int i = start; i + k < size; i++) {
            a[i] = a[i + k];
        }
        size = size - k;
        return true;
    }

    //删除顺序表中值在s与t之间的元素(s<t)
    public boolean deleteNums2(int s, int t) {
        if (size == 0) {
            System.out.println("No number to delete");
            return false;
        }
        if (s >= t) {
            System.out.println("Please input s <= t");
            return false;
        }
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] < s || a[i] > t) {
                a[k] = a[i];
                k++;
            }
        }
        size = k;
        return true;
    }

    //删除有序顺序表中所有其值重复的元素,不保留重复元素
    public void deleteRepeat1() {
        int k = 1;
        for (int i = 0; i < size - 1; i++) {
            if (a[i] == a[i + 1]) {
                k++;
                continue;
            }
            if (k > 1) {
                //从i+1向前移动k个位置
                for (int j = i + 1; j < size; j++) {
                    a[j - k] = a[j];
                }
                size = size - k;
                k = 1;
                i = -1;
            }
        }
    }

    //删除有序顺序表中所有其值重复的元素,保留一个
    public boolean deleteRepeat2() {
        if (size == 0) {
            System.out.println("No number to delete");
            return false;
        }
        int i, j;
        for (i = 0, j = 1; j < size; j++) {
            if (a[i] != a[j]) {
                a[++i] = a[j];
            }
        }
        size = i + 1;
        return true;
    }

    //将两个有序顺序表合成新的有序表
    public SeqList merge1(SeqList s1, SeqList s2) {
        SeqList s3 = new SeqList(s1.maxLength + s2.maxLength);
        System.arraycopy(s1.a, 0, s3.a, 0, s1.a.length);
        System.arraycopy(s2.a, 0, s3.a, s1.a.length, s2.a.length);
        s3.size = s1.a.length + s2.a.length;
        Arrays.sort(s3.a, 0, s3.size);
        ;
        return s3;
    }

    //将两个有序顺序表合成新的有序表
    public SeqList merge2(SeqList s1, SeqList s2) {
        SeqList s3 = new SeqList(s1.maxLength + s2.maxLength);
        int i = 0, j = 0, k = 0;
        while (i < s1.a.length && j < s2.a.length) {
            if (s1.a[i] <= s2.a[j])
                s3.a[k++] = s1.a[i++];
            else
                s3.a[k++] = s2.a[j++];
        }
        while (i < s1.a.length)
            s3.a[k++] = s1.a[i++];
        while (i < s2.a.length)
            s3.a[k++] = s2.a[j++];
        s3.size = k;
        return s3;
    }

    //线性表递增,查找x并将其与后继元素交换,不存在插入该元素使表中元素仍有序
    public boolean findOrinsert(int x, int left, int right) {
        int mid = (left + right) / 2;
        if (left <= right) {
            if (x == a[mid]) {
                if (mid < size - 1) {
                    a[mid] = a[mid + 1];
                    a[mid + 1] = x;
                }
                return true;
            } else if (x < a[mid]) {
                return findOrinsert(x, left, mid - 1);
            } else {
                return findOrinsert(x, mid + 1, right);
            }
        }
        if (mid == 0) {
            if (x <= a[mid]) {
                insert(-1, x);
            } else {
                insert(0, x);
            }
        } else {
            insert(mid, x);
        }
        return false;
    }

    //将指定范围内的顺序表元素逆置
    public void reverse(int start, int end) {
        for (int i = start; i <= start + (end - start) / 2; i++) {
            int temp = a[i];
            a[i] = a[end - i + start];
            a[end - i + start] = temp;
        }
    }

    //将顺序表中两个数组互换位置,从[a,b,c,1,2,3,4]-->[1,2,3,4,a,b,c]
    //调用reverse(int start, int end)
    public void switchArray() {
        reverse(0, size - 1);
        reverse(0, 4);
        reverse(5, 8);
    }

    public void print() {
        if (size == 0) {
            System.out.println("No num");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                System.out.print(a[i] + ",");
            } else {
                System.out.print(a[i] + "]");
            }
        }
        System.out.println();
    }
}
