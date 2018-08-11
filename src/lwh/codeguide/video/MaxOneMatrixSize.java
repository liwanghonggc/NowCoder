package lwh.codeguide.video;

/**
 * 求最大子矩阵大小
 * @author lwh
 *
 */
public class MaxOneMatrixSize {

	public static int getMaxOneMatrixSize(int[][] map){
		if(map == null || map.length == 0 || map[0].length == 0){
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(getMaxMatrix(height), maxArea);
		}
		return maxArea;
	}
	
	private static int getMaxMatrix(int[] height) {
		int n = height.length;
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i < n - 1; i++){
			for(int j = i + 1; j < n; j++){
				int h = getHeight(height, i, j);
				int temp = (j - i + 1) * h;
				maxArea = temp > maxArea ? temp : maxArea;
			}
		}
		return maxArea;
	}

	private static int getHeight(int[] height, int i, int j) {
		int min = Integer.MAX_VALUE;
		for(int k = i; k <= j; k++){
			if(height[k] < min){
				min = height[k];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[][] map = {{1,0,1,1},{1,1,0,1},{1,1,1,0}};
		System.out.println(getMaxOneMatrixSize(map));
		
	}

}
