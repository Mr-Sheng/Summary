package Algorithm.Offer.AllProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * @author Administrator
 *
 */
public class Problem41 {
	
	private static int count = 0;
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
		
	});
	
	//借助大顶堆和小顶堆来实现数据的插入操作，如果所有的数据个数是偶数，就往小顶堆里面插入，反之往大顶堆里面插入
	//在插入数据之前需要先对数据的大小进行判断，插入的数据如果小于大顶堆的堆顶，要先往大顶堆里面插入，如果大于小顶堆的堆顶，要先往小顶堆里面插入
	 public static void Insert(Integer num) {
		 count++;
		 if((count&1)==0) {
			 if (!maxHeap.isEmpty() && num<maxHeap.peek()) {
				maxHeap.offer(num);
				num = maxHeap.poll();
			}
			 minHeap.offer(num);
		 }else {
			 if (!minHeap.isEmpty() && num>minHeap.peek()) {
				minHeap.offer(num);
				num = minHeap.poll();
			}
			maxHeap.offer(num);
		 }
		 
	 }
	 
	 public static Double GetMedian() {
		 if(count==0) throw new RuntimeException("imput is null...");
		 double result;
		 if ((count&1)==1) {
			result = maxHeap.peek();
		 }else {
			result = (maxHeap.peek()+maxHeap.peek())/2.0;
		 }
		 return result;
	 }

}
