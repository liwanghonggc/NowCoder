package lwh.linearlist.linklist;

public class DbNode {

    protected int e;
    protected DbNode next;
    protected DbNode previous;

    public DbNode() {
    }

    public DbNode(int e) {
        this.e = e;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public DbNode getNext() {
        return next;
    }

    public void setNext(DbNode next) {
        this.next = next;
    }

    public DbNode getPrevious() {
        return previous;
    }

    public void setPrevious(DbNode previous) {
        this.previous = previous;
    }
}
