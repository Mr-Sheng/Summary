package Algorithm.Offer.AllProblems;
/**
 *      礼物的最大价值
 * @author Administrator
 *
 */
public class Problem47 {
	
	public static void main(String[] args) {
		int[][] values = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		System.out.println(getMaxValue2(values, 4, 4));
	}

	public static int getMaxValue(int[][] values,int rows,int cols) {
		if(values==null || rows<1 || cols<1) return 0;
		int[][] maxValues = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				int up = 0;
				int left = 0;
				if(i>0) up = maxValues[i-1][j];
				if(j>0) left = maxValues[i][j-1];
				maxValues[i][j] = Math.max(up, left)+values[i][j];
			}
		}
		int maxValue = maxValues[rows-1][cols-1];
		maxValues = null;
		return maxValue;
	}
	
	public static int getMaxValue2(int[][] values,int rows,int cols) {
		if(values==null || rows<1 || cols<1) return 0;
		int[] maxValues = new int[cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				int up = 0;
				int left = 0;
				if(i>0) up = maxValues[j];
				if(j>0) left = maxValues[j-1];
				maxValues[j] = Math.max(up, left)+values[i][j];
			}
		}
		int maxValue = maxValues[cols-1];
		maxValues = null;
		return maxValue;
	}
	
}
