package Algorithm.Offer.AllProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * @author Administrator
 *
 */
public class Problem40 {

	//时间复杂度为:O(nlogn)
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        if(input==null || k<0 || k>input.length) return list;
        Arrays.sort(input);
        for(int i=0;i<k;i++)
            list.add(input[i]);
        return list;
    }
	
	//时间复杂度为:O()
	public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		ArrayList<Integer> list= new ArrayList<Integer>();
		if(input==null || k<=0 || k>input.length) return list;
		Queue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		for(int i=0;i<input.length;i++) {
			if (queue.size()<k) {
				queue.add(input[i]);
			}else if (queue.peek()>input[i]){
				queue.poll();
				queue.add(input[i]);
			}
		}
		list.addAll(queue);
		return list;
	}
	
}
