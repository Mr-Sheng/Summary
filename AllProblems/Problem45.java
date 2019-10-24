package Algorithm.Offer.AllProblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * @author Administrator
 *
 */
public class Problem45 {

	public String PrintMinNumber(int [] numbers) {
		if(numbers==null) return "";
		int length = numbers.length;
		String[] str = new String[length];
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<length; i++) 
			str[i] = String.valueOf(numbers[i]);
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 = str1;
				return s1.compareTo(s2);
			}
		});
		for(int i=0;i<length;i++)
			sb.append(str[i]);
		return sb.toString();
		
	}
	
}
