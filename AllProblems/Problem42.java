package Algorithm.Offer.AllProblems;

/**
 * 连续子数组的最大和
 * @author Administrator
 *
 */
public class Problem42 {

	public int FindGreatestSumOfSubArray(int[] array) {
		if(array==null || array.length<=0) return 0;
		int maxValue = array[0];
		int sum = array[0]; //sum表示已经累加过的数组值
		for (int i = 1; i < array.length; i++) {
			//如果这些已经累加过的值之和为非负，说明这个累加和对整体最大和有帮助，继续往上累加，否则就抛弃之前的累加和，从当前数组值重新开始累加
			if (sum>=0) {
				sum += array[i];
			}else {
				sum = array[i];
			}
			//判断已经计算完的累加和是否比全局存储的最大值要大，如果是则把全局最大值进行更新
			if (sum>maxValue) maxValue = sum;
		}
		return maxValue;
	}
	
}
