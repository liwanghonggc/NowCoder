package lwh.queue;

public class LinkedQueueTest {

    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.enQueue(5);
        q.enQueue(4);
        q.enQueue(3);
        q.enQueue(2);
        q.enQueue(1);

        //q.printMatrix();

        q.reverse();
        q.print();
        q.print();
    }

}
