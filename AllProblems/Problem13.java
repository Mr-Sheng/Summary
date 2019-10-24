package Algorithm.Offer.AllProblems;
/**
 * 机器人的运动范围
 * @author Administrator
 *
 */
public class Problem13 {

	public int movingCount(int threshold, int rows, int cols){
		if(threshold<0 || rows<1 || cols<1) return 0;
		boolean[] visited = new boolean[rows*cols];
		for(int i=0;i<rows*cols;i++)
			visited[i] = false;
		int count = movingCountCore(threshold,rows,cols,0,0,visited);
		return count;
	}

	private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		if(row>=0 && row<rows && col>=0 && col<cols && (getDigitNum(row)+getDigitNum(col)<=threshold) && !visited[row*cols+col]) {
			visited[row*cols+col] = true;
			count = 1 + movingCountCore(threshold, rows, cols, row-1, col, visited)
					+ movingCountCore(threshold, rows, cols, row+1, col, visited)
					+ movingCountCore(threshold, rows, cols, row, col-1, visited)
					+ movingCountCore(threshold, rows, cols, row, col+1, visited);
		}
		return count;
	}

	private int getDigitNum(int number) {
		int sum = 0;
		while(number>0) {
			sum += number%10;
			number /= 10;
		}
		return sum;
	}

	
}
