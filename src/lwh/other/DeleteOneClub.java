package lwh.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteOneClub {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            getResult(n, arr);
        }
    }

    private static void getResult(int n, int[][] arr) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j < n; j++){
                if(i != j){
                    if(isInterSect(arr[i][0], arr[i][1], arr[j][0], arr[j][1])){
                        list.add(j);
                    }
                }
            }
            res.add(list);
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<List<Integer>> temp = new ArrayList<>(res);
            int num = 0;
            for(int j = 0; j < n; j++){
                if(i != j){
                    List<Integer> tmpList = temp.get(j);
                    if(tmpList.contains(i)){
                        if(tmpList.size() == 1){
                            tmpList = new ArrayList<>();
                        }else{
                            tmpList.remove(i);
                        }
                    }
                    if(tmpList.size() > 0){
                        break;
                    }else{
                        num++;
                    }
                }
            }
            if(num == n - 1){
                count++;
                result.add(i + 1);
            }

        }

        if(count == 0){
            System.out.println(0);
        }else{
            System.out.println(count);
            int len = result.size();
            for(int i = 0; i < len; i++){
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInterSect(int a, int b, int c, int d){
        if(b <= c || d <= a){
            return false;
        }
        return true;
    }
}
