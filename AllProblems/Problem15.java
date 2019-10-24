package Algorithm.Offer.AllProblems;

public class Problem15 {
	
	public static void main(String[] args) {
		System.out.println(reverseMtoN(10,14));
	}
	
	public static int bestNumberOf1(int n) {
		int count = 0;
		while(n!=0) {
			++count;
			n = (n-1)&n;
		}
		return count;
	}

	public static int NumberOf1(int n) {
		int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag = flag<<1;
        }
        return count;
	}
	
	public static int reverseMtoN(int m,int n) {
		return NumberOf1(m^n);
	}
	
}
