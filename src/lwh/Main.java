package lwh;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int monkeyNum = sc.nextInt();
            int peachNum = sc.nextInt();

            List<Integer> peachList = new ArrayList<>();
            for (int i = 0; i < peachNum; i++) {
                peachList.add(sc.nextInt());
            }

            ArrayList<Integer> monList = new ArrayList<>();
            Map<Integer, Integer> monkey = new TreeMap<>();

            for (int i = 0; i < monkeyNum; i++) {
                int fight = -sc.nextInt();
                monList.add(fight);
                monkey.put(fight, sc.nextInt());
            }

            Collections.sort(peachList);
            Collections.reverse(peachList);

            for (int key : monkey.keySet()) {
                List<Integer> rm = new ArrayList<>();
                int len = peachList.size();
                for (int i = 0; i < len; i++) {
                    if (monkey.get(key) - peachList.get(i) >= 0) {
                        monkey.put(key, monkey.get(key) - peachList.get(i));
                        rm.add(i);
                    }
                }

                for (int k = rm.size() - 1; k >= 0; k--) {
                    peachList.remove(k);
                }
            }

            for (int key : monList) {
                System.out.println(monkey.get(key));
            }
        }
    }
}
