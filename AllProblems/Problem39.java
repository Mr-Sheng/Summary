package Algorithm.Offer.AllProblems;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 * @author Administrator
 *
 */
public class Problem39 {

	//时间复杂度为:O(nlogn)
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null) return 0;
        Arrays.sort(array);
        int middle = array[array.length/2];
        int count = 0;
        for(int i=0;i<array.length;i++)
            if(array[i]==middle) count++;
        return count>(array.length/2) ? middle:0;
    }
	
	//时间复杂度为:O(n)
	public int MoreThanHalfNum_Solution2(int [] array) {
        if(array==null) return 0;
        int result = array[0];
        int times = 1;
        for(int i=1;i<array.length;i++){
            if(times==0){
                result = array[i];
                times = 1;
            }else if(array[i]==result){
                ++times;
            }else{
                --times;
            }
        }
        times = 0;
        for(int i=0;i<array.length;i++)
            if(array[i]==result) times++;
        return (times>array.length/2) ? result:0;
    }
	
}
