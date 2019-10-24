package Algorithm.Offer.AllProblems;

public class Problem10 {
	
	public static void main(String[] args) {
		
//		long start1 = System.currentTimeMillis();
//		System.out.println(bestFibonacci(100000000));
//		long end1 = System.currentTimeMillis();
//		System.out.println(end1-start1);
//		
//		long start2 = System.currentTimeMillis();
//		System.out.println(Fibonacci(100000000));
//		long end2 = System.currentTimeMillis();
//		System.out.println(end2-start2);
		
		
		
//		long start3 = System.currentTimeMillis();
//		System.out.println(lowFibonacci(45));
//		long end3 = System.currentTimeMillis();
//		System.out.println(end3-start3);
		
		System.out.println(jumpingStairs(3));
	}
	
	public static int[][] mult(int[][] matrix1, int[][] matrix2) {
		int[][] matrix = new int[2][2];
		matrix[0][0] = matrix1[0][0]*matrix2[0][0]+matrix1[0][1]*matrix2[1][0];
		matrix[0][1] = matrix1[0][0]*matrix2[0][1]+matrix1[0][1]*matrix2[1][1];
		matrix[1][0] = matrix1[1][0]*matrix2[0][0]+matrix1[1][1]*matrix2[1][0];
		matrix[1][1] = matrix1[1][0]*matrix2[0][1]+matrix1[1][1]*matrix2[1][1];
		return matrix;
	}
	
	public static int[][] result(int x){
		
		int[][] res = new int[2][2];
		
		if (x==0) {
			res[0][0] = res[1][1] = 1;
			res[0][1] = res[1][0] = 0;
			return res;
		}
		if (x==1) {
			res[0][0] = res[0][1] = res[1][0] = 1;
			res[1][1] = 0;
			return res;
		}
		
		return mult(mult(result(x/2), result(x/2)), result(x%2));
	}
	
	public static int bestFibonacci(int n) {
		
		if (n<=1) {
			return n;
		}
		int[][] mat = result(n-1);
		
		return mat[0][0];
	}

	public static int Fibonacci(int n) {
		if(n<=0) {
			return 0;
		}else if (n==1) {
			return 1;
		}else {
			int[] value = new int[n+1];
			value[0] = 0;
			value[1] = 1;
			for(int i=2;i<=n;i++) {
				value[i%3] = value[(i-2)%3]+value[(i-1)%3];
			}
			return value[n%3];
		}
	}
	
	public static int lowFibonacci(int n) {
		if (n<=0) {
			return 0;
		}else if (n==1) {
			return 1;
		}else {
			return lowFibonacci(n-1)+lowFibonacci(n-2);
		}
	}
	
	
	public static int jumpingStairs(int target) {
//		if (target<=0) {
//			return 0;
//		}else if(target==1) {
//			return 1;
//		}else if (target==2) {
//			return 2;
//		}else {
//			return jumpingStairs(target-1)+jumpingStairs(target-2);
//		}
		if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else if(target>2){
            int[] result = new int[3];
            result[0] = 1;
            result[1] = 1;
            for(int i=2;i<=target;i++){
                result[i%3] = result[(i-2)%3] + result[(i-1)%3];
            }
            return result[target%3];
        }else{
            return 0;
        }
	}
	
	public static int JumpFloorII(int target) {
		if (target<=0) {
			return 0;
		}else if (target==1) {
			return 1;
		}else {
			return JumpFloorII(target-1)*2;
		}
	}
	
}
