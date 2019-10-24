package Algorithm.Offer.AllProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 和为s的数字
 * @author Administrator
 *
 */
public class Problem57 {

	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array==null || array.length<0) return list;
        int length = array.length;
        int result = 0;
        boolean tag = false;
        int temp = 0;
        int a=-1,b=-1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<length;i++){
            if(map.containsKey(array[i])){
                if(!tag){
                    result = array[i]*array[map.get(array[i])];
                    a = map.get(array[i]);
                    b = i;
                    tag = true;
                }else{
                    temp = array[i]*array[map.get(array[i])];
                    if(temp<result){
                        a = map.get(array[i]);
                        b = i;
                        result = temp;
                    }
                }
            }else{
                map.put(sum-array[i],i);
            }
        }
        if(a>-1 && b>-1){
            list.add(array[a]);
            list.add(array[b]);
            return list;
        }else{
            return list;
        }
        
    }
	
	
	public ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array==null || array.length<=0) return list;
        int length = array.length;
        int before = 0;
        int after = length-1;
        int result = 0;
        boolean tag = false;
        int a=-1,b=-1;
        while(before!=after){
            if(array[before]+array[after]==sum){
                if(!tag){
                    result = array[before]*array[after];
                    a = before;
                    b = after;
                    tag = true;
                }else{
                    int temp = array[before]*array[after];
                    if(temp<result){
                        a = before;
                        b = after;
                        result = temp;
                    }
                }
                before++;
            }else if(array[before]+array[after]<sum){
                before++;
            }else{
                after--;
            }
        }
        
        if(!tag){
            return list;
        }else{
            list.add(array[a]);
            list.add(array[b]);
            return list;
        }
    }
	
	//和为s的连续正数序列
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> innerList = new ArrayList<Integer>();
        int small = 1;
        int big = 2;
        int mid = (1+sum)>>1;
        int curSum = small+big;
        while(small<mid){
            if(curSum==sum){
                for(int i=small;i<=big;i++)
                    innerList.add(i);
                list.add(innerList);
                innerList = new ArrayList<Integer>();
                curSum -= small; 
                small++;
            }else if(curSum<sum){
                big++;
                curSum += big;
            }else{
                curSum -= small;
                small++;
            }
        }
        return list;
    }
	
}
