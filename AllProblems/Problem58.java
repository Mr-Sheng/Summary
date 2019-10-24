package Algorithm.Offer.AllProblems;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 	翻转单词顺序
 * @author Administrator
 *
 */
public class Problem58 {
	
	public static void main(String[] args) {
		String str = "I am a student.";
		System.out.println(ReverseSentence(str));
	}
	
	//翻转字符串,多个空格只保留一个,并且去除首尾空格
	public static String reverseString(String s) {
		char[] charArray = s.trim().toCharArray();
		reverseCharArray(charArray);
		s = String.valueOf(charArray);
		String[] splitString = s.split("\\s+");
		int len = splitString.length;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++) {
			char[] tempArray = splitString[i].toCharArray();
			reverseCharArray(tempArray);
			sb.append(String.valueOf(tempArray));
			if(i!=len-1) sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void reverseCharArray(char[] array) {
		if(array==null || array.length<1) return;
		int left = 0, right = array.length-1;
		while(left<right) {
			char temp = array[left];
			array[left++] = array[right];
			array[right--] = temp;
		}
	}
	
	//字符串中最长无重复子串的长度
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

	//翻转字符串,单词不翻转
	public static String ReverseSentence(String str) {
        if(str==null) return "";
        Stack<String> stack = new Stack<String>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(' '==(str.charAt(i))){
                stack.push(sb.toString());
                stack.push(" ");
                sb = new StringBuffer();
            }else{
                sb.append(str.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
	
	//翻转字符串,单词不翻转
	public static String ReverseSentence2(String str) {
        if(str==null) return null;
        char[] charArray = str.toCharArray();
        int length = str.length();
        Reverse(charArray,0,length-1);
        System.out.println(new String(charArray));
        for(int start=0,end=0;end<length;end++){
            if(end==length-1){
                Reverse(charArray,start,end);
                break;
            }
            if(' '==charArray[end]){
                Reverse(charArray,start,end-1);
                start = end+1;
            }
        }
        return new String(charArray);
    }
	//翻转字符数组
    public static void Reverse(char[] charArray,int start,int end){
        if(charArray==null || start==end) return;
        while(start<end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
	
	//左旋转字符串
	public String LeftRotateString(String str,int n) {
        if(str==null || n>str.length()) return "";
        int length = str.length();
        StringBuffer sb = new StringBuffer();
        for(int i=n;i<length;i++)
            sb.append(str.charAt(i));
        for(int i=0;i<n;i++)
            sb.append(str.charAt(i));
        return sb.toString();
    }
	
}
