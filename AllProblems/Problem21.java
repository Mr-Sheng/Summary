package Algorithm.Offer.AllProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author Administrator
 *
 */
public class Problem21 {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		reOrderArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

	//这种方法只能保证奇数在前面，偶数在后面，不能保证交换后的相对位置不变
	public static void reOrderArray(int [] array) {
		if (array==null || array.length<=0) return;
		int length = array.length;
		int i=0,j=length-1;
		for(;i<length;i++) {
			if (i==j) break;
			if(array[i]%2==0) {
				while(j>i) {
					if(array[j]%2==1) {
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						j--;
						break;
					}else {
						j--;
					}
				}
			}
		}
	}
	
	//这种方法可以保证交换后的相对位置不发生变化
	public static void reOrderArray2(int [] array) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++){
		    if(array[i]%2==1){
		        list1.add(array[i]);
		    }else{
		        list2.add(array[i]);
		    }
		}
		int index = list1.size();
		for(int i=0;i<index;i++){
		    array[i] = list1.get(i);
		}
		for(int i=0;i<list2.size();i++){
		    array[index++] = list2.get(i);
		}
	}
	
}


