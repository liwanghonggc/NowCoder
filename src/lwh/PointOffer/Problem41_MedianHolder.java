package lwh.PointOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem41_MedianHolder {

    public static void main(String[] args) {
        MedianHolder holder = new MedianHolder();
        holder.addNum(1);
        holder.addNum(2);
        holder.addNum(4);
        holder.addNum(6);

        System.out.println(holder.getMedian());
    }


}

class MedianHolder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianHolder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }
            if (minHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }

        modifyTwoHeap();
    }

    public Integer getMedian() {
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();

        int len = maxSize + minSize;
        if (len == 0) {
            return null;
        }
        Integer maxHeap = this.maxHeap.peek();
        Integer minHeap = this.minHeap.peek();

        if (len % 2 == 0) {
            return (maxHeap + minHeap) / 2;
        } else if (maxSize > minSize) {
            return maxHeap;
        } else {
            return minHeap;
        }
    }

    private void modifyTwoHeap() {
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

}
