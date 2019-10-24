package Algorithm.Offer.AllProblems;

/**
 * 数值的整数次方
 * @author Administrator
 *
 */
public class Problem16 {
	
	public static void main(String[] args) {
		System.out.println(Power(-5.0,1));
	}
	
	public static double Power(double base, int exponent) {
		boolean invaldInput = false;
		int absExponent = exponent;
		if (base==0.0 && exponent<0) {
			invaldInput = true;
			return 0.0;
		}
		if (exponent<0) absExponent = -exponent;
		double result = PowerWithUnsignedExpoment(base,absExponent);
		if(exponent<0) 
			result = 1.0/result;
		return result;
	}
	
	public static double PowerWithUnsignedExpoment(double base, int exponent) {
		if(exponent==0)
			return 1;
		if(exponent==1)
			return base;
		double result = PowerWithUnsignedExpoment(base,exponent>>1);
		result *= result;
		if((exponent & 0x1)==1)
			result *= base;
		return result;
	}

}
