package Algorithm.Offer.AllProblems;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * @author Administrator
 *
 */
public class Problem61 {

	public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length<=0) return false;
        int length = numbers.length;
        Arrays.sort(numbers);
        int numZero = 0;
        int numGrap = 0;
        for(int i=0;i<length;i++)
            if(numbers[i]==0)
                numZero++;
        int small=numZero,big=small+1;
        while(big<length){
            if(numbers[big]==numbers[small])
                return false;
            numGrap += numbers[big]-numbers[small]-1;
            small = big;
            ++big;
        }
        return (numGrap>numZero) ? false:true;
    }
	
}
