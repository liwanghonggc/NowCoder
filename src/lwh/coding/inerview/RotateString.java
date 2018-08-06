package lwh.coding.inerview;

import java.util.Arrays;

//将一个字符串str右移k位,额外空间复杂度O(1)
public class RotateString {

    public static void main(String[] args) {
        String str1 = "abcd";
        rotateString(str1.toCharArray(), 5);
    }

    public static void rotateString(char[] chs, int n){
        if(chs == null || chs.length == 0){
            return;
        }
        n = n % chs.length;
        int mid = chs.length - n - 1;
        rotate(chs, 0, mid);
        rotate(chs, mid + 1, chs.length - 1);
        rotate(chs, 0, chs.length - 1);
        System.out.println(Arrays.toString(chs));
    }

    public static void rotate(char[] chs, int left, int right){
        while(left < right){
            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }
    }
}
