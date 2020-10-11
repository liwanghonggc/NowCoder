package lwh.stack;

public class SeqStack {

    private static final int maxLen = 10;
    private int top;
    private int[] a;

    public SeqStack() {
        initStack();
        a = new int[maxLen];
    }

    public void initStack() {
        top = -1;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    public boolean push(int x) {
        if (top == maxLen - 1) {
            return false;
        }
        a[++top] = x;
        return true;
    }

    //弹出栈顶元素
    public Result pop() {
        Result r = new Result();
        if (top == -1) {
            r.setFlag(false);
            return r;
        }
        r.setX(a[top--]);
        return r;
    }

    //读栈顶元素
    public Result get() {
        Result r = new Result();
        if (top == -1) {
            r.setFlag(false);
            return r;
        }
        r.setX(a[top]);
        return r;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("No num");
            return;
        }
        System.out.print("[");
        while (!isEmpty()) {
            System.out.print(pop().getX() + ",");
        }
        System.out.println("]");
    }
}
