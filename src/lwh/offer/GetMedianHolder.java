package lwh.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianHolder {

    private static PriorityQueue<Integer> smallPQ = new PriorityQueue<>();

    private static PriorityQueue<Integer> bigPQ = new PriorityQueue<>(new BigComparator());

    private static class BigComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void Insert(Integer num) {
        if(bigPQ.isEmpty()){
            bigPQ.add(num);
            return;
        }

        if(num <= bigPQ.peek()){
            bigPQ.add(num);
        }else {
            smallPQ.add(num);
        }

        int diff = bigPQ.size() - smallPQ.size();
        if(diff > 1){
            while(bigPQ.size() - smallPQ.size() > 1){
                smallPQ.add(bigPQ.poll());
            }
        }else{
            while(smallPQ.size() - bigPQ.size() > 1){
                bigPQ.add(smallPQ.poll());
            }
        }

    }

    public static Double GetMedian() {
        int count1 = bigPQ.size();
        int count2 = smallPQ.size();

        if(bigPQ.size() <= 0){
            return null;
        }

        double num1 = bigPQ.peek();
        double num2 = 0;

        if(smallPQ.size() > 0){
            num2 = smallPQ.peek();
        }

        if(count1 == count2){
            return (num1 + num2) / 2;
        }else if(count1 < count2){
            return num2;
        }else{
            return num1;
        }
    }

    public static void main(String[] args) {
        GetMedianHolder.Insert(4);
        GetMedianHolder.Insert(5);
        GetMedianHolder.Insert(6);
        GetMedianHolder.Insert(7);

        System.out.println(GetMedian());
    }
}
