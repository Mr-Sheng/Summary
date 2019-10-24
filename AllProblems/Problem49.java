package Algorithm.Offer.AllProblems;

/**
 * 丑数
 * @author Administrator
 *
 */
public class Problem49 {
	
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(1500));
	}

	//这种方法时间效率差，无法通过验证
	public static int GetUglyNumber_Solution(int index) {
        if(index<=0) return 0;
        int number = 0;
        int uglyFound = 0;
        while(uglyFound<index){
            ++number;
            if(isUgly(number))
                uglyFound++;
        }
        return number;
    }
    
    public static boolean isUgly(int number){
        while(number%2==0) number /= 2;
        while(number%3==0) number /= 3;
        while(number%5==0) number /= 5;
        return (number==1) ? true:false;
    }
    
    //
    public static int GetUglyNumber_Solution2(int index) {
    	if(index<=0) return 0;
    	if(index>=1 && index<=7) return index;
    	int[] uglyNum = new int[index];
    	uglyNum[0] = 1;
    	int t2=0,t3=0,t5=0;
    	for(int i=1;i<index;i++) {
    		uglyNum[i] = Math.min(Math.min(uglyNum[t2]*2, uglyNum[t3]*3), uglyNum[t5]*5);
    		if(uglyNum[i]==uglyNum[t2]*2) t2++;
    		if(uglyNum[i]==uglyNum[t3]*3) t3++;
    		if(uglyNum[i]==uglyNum[t5]*5) t5++;
    	}
    	return uglyNum[index-1];
    }
	
}
