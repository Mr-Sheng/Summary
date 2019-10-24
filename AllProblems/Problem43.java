package Algorithm.Offer.AllProblems;

/**
 * 1~n整数中1出现的次数
 * @author Administrator
 *
 */
public class Problem43 {

	public int NumberOf1Between1AndN_Solution(int n) {
        int number = 0;
        for(int i=1;i<=n;i++)
            number += NumberOf1(i);
        return number;
    }
    
    public int NumberOf1(int n){
        int number = 0;
        while(n>0){
            if(n%10==1)
                number++;
            n = n/10;
        }
        return number;
    }
    
    public int NumberOf1Between1AndN_Solution2(int n) {
    	StringBuffer sb = new StringBuffer();
    	int count = 0;
    	for(int i=1;i<=n;i++)
    		sb.append(i);
    	int length = sb.toString().length();
    	for(int i=0;i<length;i++)
    		if(sb.charAt(i)=='1')
    			count++;
    	return count;
    }
	
}
