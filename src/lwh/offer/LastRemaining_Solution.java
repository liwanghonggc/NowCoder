package lwh.offer;

public class LastRemaining_Solution {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution2(8, 5));
    }

    public static int LastRemaining_Solution1(int n, int m) {
        if(n <= 0 || m <= 0){
            return -1;
        }
        if(n == 1){
            return 0;
        }

        boolean[] flag = new boolean[n];
        int count = n;
        int temp = 0;
        int index = 0;

        while(count > 1){
            while(temp != m - 1 || flag[index]){
                if(!flag[index]){
                    temp++;
                }
                index = (index + 1) % n;
            }
            flag[index] = true;
            index = (index + 1) % n;
            temp = 0;
            count--;
        }

        for(int i = 0; i < flag.length; i++){
            if(!flag[i]){
                return i;
            }
        }

        return -1;
    }

    public static int LastRemaining_Solution2(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++){
            last = (last + m) % i;
        }
        return last;
    }
}
