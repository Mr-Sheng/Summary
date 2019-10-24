package Algorithm.Offer.AllProblems;

/**
 * 数组中重复的数字
 * @author Administrator
 *
 */
public class Problem03 {

	public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || length<=0) return false;
        int j = 0;
        for(int i=0;i<length;i++){
            if(numbers[i]<0 || numbers[i]>length)
                return false;
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[j++] = numbers[i];
                    return true;
                }else{
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }
	
}
