package lwh.PointOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lwh
 * @date 2018-09-17
 * @desp 两个队列实现一个栈
 */
public class Problem9_TwoQueueGetStack {

    private static final Queue<Integer> queue1 = new LinkedList<>();

    private static final Queue<Integer> queue2 = new LinkedList<>();

    /**
     * 入栈,直接放到queue1
     * @param num
     */
    public void add(Integer num){
        queue1.add(num);
    }

    /**
     * 出栈,依次将queue1中元素放入queue2,直到最后一个元素,将其弹出,最后将queue2中元素放回queue1中
     * @return
     */
    public Integer get(){
        int len = queue1.size();
        for(int i = 0; i < len - 1; i++){
            int num = queue1.poll();
            queue2.add(num);
        }
        int res = queue1.poll();
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        Problem9_TwoQueueGetStack stack = new Problem9_TwoQueueGetStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack.get());
        System.out.println(stack.get());
    }
}
