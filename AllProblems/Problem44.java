package Algorithm.Offer.AllProblems;

/**
 * 数字序列中某一位的数字
 * @author Administrator
 *
 */
public class Problem44 {
	
	public static void main(String[] args) {
		String digit = "01234567891011121314151617181920";
	}

	public static int digitAtIndex(int digit,int index) {
		StringBuilder sb = new StringBuilder();
		sb = sb.append(String.valueOf(digit));
		return sb.charAt(index);
	}
	
}
