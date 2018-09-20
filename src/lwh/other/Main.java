package lwh.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwh
 * @date 2018-09-19
 * @desp
 */
public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int i = list.size() - 1; i >= 0; i--){
            list.remove(2);
        }

        System.out.println(list.toString());
    }
}
