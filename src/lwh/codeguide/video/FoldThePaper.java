package lwh.codeguide.video;

public class FoldThePaper {

	public static void printAllFolds(int N){
		printDownAndUP(1, N, true);
	}
	public static void printDownAndUP(int i, int N, boolean flag){
		if(i > N){
			return;
		}
		printDownAndUP(i + 1, N, true);
		System.out.println(flag ? "down" : "up");
		printDownAndUP(i + 1, N, false);
	}
	
	public static void main(String[] args) {
		printAllFolds(3);
	}

}
