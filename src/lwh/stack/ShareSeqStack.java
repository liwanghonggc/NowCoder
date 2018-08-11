package lwh.stack;

public class ShareSeqStack {

	private static final int maxLen = 10;
	private int ltop;
	private int rtop;
	private int[] a;
	
	public ShareSeqStack(){
		a = new int[maxLen];
	}
	
	public void initStack(){
		ltop = -1;
		rtop = maxLen;
	}
	
	public boolean lpush(int x){
		if(rtop - ltop == 1){
			return false;
		}
		a[++ltop] = x;
		return true;
	}
	
	public boolean rpush(int x){
		if(rtop - ltop == 1){
			return false;
		}
		a[--rtop] = x;
		return true;
	}
	
	public Result lpop(){
		Result r = new Result();
		if(ltop == -1){
			r.setFlag(false);
			return r;
		}
		r.setX(a[ltop--]);
		return r;
	}
	
	public Result rpop(){
		Result r = new Result();
		if(rtop == maxLen){
			r.setFlag(false);
			return r;
		}
		r.setX(a[rtop++]);
		return r;
	}
}
