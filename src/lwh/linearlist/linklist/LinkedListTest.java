package lwh.linearlist.linklist;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.createListTail();

        LinkedList list2 = new LinkedList();
        list2.createListTail();

        list1.print();
        list2.print();

        System.out.println(list1.AisContainsB2(list2));
    }

}
