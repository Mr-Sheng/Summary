package Algorithm.Offer.AllProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * @author Administrator
 *
 */
public class Problem50 {
	
	public static void main(String[] args) {
		String str1 = "aebdgol";
		String str = "google";
		System.out.println(DeleteSecondCharFromFirstString(str1,str));
//		System.out.println(FirstNotRepeatingChar(str));
	}

	//第一遍扫描字符串，将出现的所有的字符以及对应的出现的次数都保存到一个哈希表中，第二次扫描就可以在O(1)的时间得到只出现一次的字符
	public static int FirstNotRepeatingChar(String str) {
		if(str==null || str.length()<=0) return -1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int length = str.length();
		for(int i=0;i<length;i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}else {
				map.put(str.charAt(i),1);
			}
		}
		for(int i=0;i<length;i++) {
			if (map.get(str.charAt(i))==1) {
				return i;
			}
		}
		return -1;
    }
	
	//从第一个字符串中删除第二个字符串中出现过的字符
	public static String DeleteSecondCharFromFirstString(String str1,String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<length2;i++) {
			if(!map.containsKey(str2.charAt(i))) {
				map.put(str2.charAt(i), 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length1;i++) 
			sb.append(str1.charAt(i));
		
		StringBuilder sb2 = new StringBuilder();
		
		for(int i=0;i<sb.length();i++) {
			if(!map.containsKey(str1.charAt(i))) {
				sb2.append(str1.charAt(i));
			}
				
		}
		return sb2.toString();
	}
	
}
