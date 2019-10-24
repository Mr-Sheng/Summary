package Algorithm.Offer.AllProblems;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @author Administrator
 *
 */
public class Problem64 {

	public int Sum_Solution(int n) {
		int sum = n;
		boolean flag = (sum>0) && ((sum += Sum_Solution(--n))>0);
		return sum;
	}
	
	public int Sum_Solution2(int n) {
		return ((int)Math.pow(n, n+1))>>1;
	}
	
}
