package lwh.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lwh
 * @date 2019-04-03
 * @desp
 */
public class Main1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            list.add(str);
        }

        System.out.println(num);
        System.out.println(list);
    }
}
