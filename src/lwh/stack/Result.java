package lwh.stack;

//定义返回值
public class Result {
    private boolean flag;
    private int x;

    public Result() {
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Result(boolean flag, int x) {
        super();
        this.flag = flag;
        this.x = x;
    }
}
