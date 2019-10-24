package Algorithm.Offer.AllProblems;


public class Problem02 {
	
//	private static Singleton singleton = new Singleton();
//	private Singleton() {
//		if (singleton!=null) {
//			throw new RuntimeException();
//		}
//	}
//	public static Singleton getInstance() {
//		return singleton;
//	}
	
	
//	private static Singleton singleton;
//	private Singleton() {
//		if (singleton!=null) {
//			throw new RuntimeException();
//		}
//	}
//	public static synchronized Singleton getInstance() {
//		if (singleton==null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
	
	
//	private volatile static Singleton singleton;
//	private Singleton() {
//		if (singleton!=null) {
//			throw new RuntimeException();
//		}
//	}
//	public static Singleton getInstance() {
//		if (singleton==null) {
//			synchronized (Singleton.class) {
//				if (singleton==null) {
//					singleton = new Singleton();
//				}
//			}
//		}
//		return singleton;
//	}
	
	private static class SingletonClass{
		private static final Problem02 singleton = new Problem02();
	}
	private Problem02() {
		if (Problem02.SingletonClass.singleton!=null) {
			throw new RuntimeException();
		}
	}
	
	public static Problem02 getInstance() {
		return Problem02.SingletonClass.singleton;
	}
	
	
	public static int find(int[] arr) {
		
		int[] arr2 = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==arr2[arr[i]+1]) {
				return arr[i];
			}
			arr2[arr[i]+1] = arr[i];
		}
		return -1;
	}
	
	public static int getDuplication(int[] arr,int length) {
		if (arr==null||arr.length<=0) return -1;
		int start = 1;
		int end = arr.length;
		while(end>=start) {
			int middle = ((end-start)>>1)+start;
			int count = countRange(arr, length, start, end);
			if (end==start) {
				if (count>1) {
					return start;
				}else {
					break;
				}
			}
			if (count>(middle-start+1)) {
				end = middle;
			}else {
				start = middle+1;
			}
		}
		return -1;
	}
	
	public static int countRange(int[] arr,int length,int start,int end) {
		if (arr==null) return 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>=start && arr[i]<=end) {
				++count;
			}
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {2,3,5,4,2,3,6,7};
		System.out.println(find(arr));
		System.out.println(getDuplication(arr, 8));
	}

}
