package Algorithm.Offer.AllProblems;

import java.util.Arrays;

public class Problem01 {
	
	public static int find(int[] arr) {
//		int result = -1;
//		boolean tag = true;
//		for (int i = 0; i < arr.length && tag == true; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				if (arr[i]==arr[j]) {
//					result = arr[i];
//					tag = false;
//					break;
//				}
//			}
//		}
//		return result;
		
		
//		int result = -1;
//		Arrays.sort(arr);
//		for (int i = 0; i < arr.length-1; i++) {
//			if (arr[i]==arr[i+1]) {
//				result = arr[i];
//				break;
//			}
//		}
//		return result;
		
//		int result = -1;
//		
//		if (arr==null || arr.length<0) {
//			return result;
//		}
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i]<0 || arr[i]>arr.length) {
//				return result;
//			}
//		}
//		
//		
//		for (int i = 0; i < arr.length; i++) {
//			while (i!=arr[i]) {
//				if (arr[i]==arr[arr[i]]) {
//					return arr[i];
//				}
//				int temp = arr[i];
//				arr[i] = arr[arr[i]];
//				arr[temp] = temp;
//			}
//		}
//		return result;
		
		int result = -1;
		
		if (arr==null || arr.length<0) {
			return result;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]<0 || arr[i]>arr.length) {
				return result;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			while(i!=arr[i]) {
				if (arr[i]==arr[arr[i]]) {
					return arr[i];
				}
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}
		return result;
		
		
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,1,0,2,5,3};
		int[] arr1 = {};
		System.out.println(find(arr));
	}

}
