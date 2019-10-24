package Algorithm.Offer.AllProblems;

/**
 * 不用加减乘除做加法
 * @author Administrator
 *
 */
public class Problem65 {
	
	public static void main(String[] args) {
		Exchange(1, 2);
		Exchange2(1, 2);
	}

	public int Add(int num1,int num2) {
		int sum1,sum2;
        do{
            //异或运算，求出两数单纯相加不进位的值
            sum1 = num1 ^ num2;
            //位与运算，求出两数进位的位置，并且将它左移一位得到需要进位的数字
            sum2 = (num1 & num2)<<1;
            //从上面得到的两数相加就是原来两个数相加的结果，循环计算
            num1 = sum1;
            num2 = sum2;
        }while(num2!=0);
        return sum1;
	}
	
	//不使用新变量交换两个数的值
	public static void Exchange(int a,int b) {
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a);
		System.out.println(b);
	}
	
	public static void Exchange2(int a,int b) {
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println(a);
		System.out.println(b);
	}
	
}
