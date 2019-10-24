package Algorithm.Offer.AllProblems;

import java.util.HashSet;
import java.util.Set;

public class Problem48 {
	
	public static void main(String[] args) {
		String str = "arabcacfr";
		System.out.println(longestSubstringWithoutDuplication(str));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<Character>();
		int slow = 0, fast = 0, len = s.length();
		int maxLen = 0;
		while(slow<len && fast<len) {
			if(!set.contains(s.charAt(fast))) {
				set.add(s.charAt(fast++));
				maxLen = Math.max(maxLen, fast-slow);
			}else {
				set.remove(s.charAt(slow++));
			}
		}
		return maxLen;
	}
	
	public static int longestSubstringWithoutDuplication(String str) {
		if(str==null || str.length()<1) return 0;
		int length = str.length();
		int curLength = 0;
		int maxLength = 0;
		int[] position = new int[26];
		for(int i=0;i<26;i++)
			position[i] = -1;
		for(int i=0;i<length;i++) {
			int preIndex = position[str.charAt(i)-'a'];
			if(preIndex<0 || i-preIndex>curLength) {
				++curLength;
			} else {
				if(curLength>maxLength)
					maxLength = curLength;
				curLength = i-preIndex;
			}
			position[str.charAt(i)-'a'] = i;
		}
		if(curLength>maxLength)
			maxLength = curLength;
		position = null;
		return maxLength;
	}

//	public static int longestSubstringWithoutDuplication(String str) {
//		if(str==null || str.length()<1) return 0;
//		int length = str.length();
//		int curLength = 0;
//		int maxLength = 0;
//		int[] position = new int[26];
//		for(int i=0;i<26;i++)
//			position[i] = -1;
//		for(int i=0;i<length;i++) {
//			int preIndex = position[str.charAt(i)-'a'];
//			if(preIndex<0 || i-preIndex>curLength) {
//				++curLength;
//			}else {
//				if(curLength>maxLength) 
//					maxLength = curLength;
//				curLength = i-preIndex;
//			}
//			position[str.charAt(i)-'a'] = i;
//		}
//		if(curLength>maxLength)
//			maxLength = curLength;
//		position = null;
//		return maxLength;
//	}
	
}
