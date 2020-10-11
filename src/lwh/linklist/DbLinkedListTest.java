package lwh.linklist;

public class DbLinkedListTest {

    public static void main(String[] args) {
        DbLinkedList list = new DbLinkedList();
        list.insertHead(5);
        list.insertHead(3);
        list.insertHead(9);
        list.insertHead(4);
        list.insertHead(1);
        list.print();

        list.length();

        list.deleteNode(1);
        list.print();
    }

}
