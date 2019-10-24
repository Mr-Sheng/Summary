package Algorithm.Offer.AllProblems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Problem59 {

	public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int length = num.length;
        if(length>=size && size>=1){
            Deque<Integer> deque = new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                while(!deque.isEmpty() && num[i]>=num[deque.peekLast()])
                    deque.pollLast();
                deque.addLast(i);
            }
            for(int i=size;i<length;i++){
                list.add(num[deque.peekFirst()]);
                while(!deque.isEmpty() && num[i]>=num[deque.peekLast()])
                    deque.pollLast();
                if(!deque.isEmpty() && deque.peekFirst()<=(i-size))
                    deque.pollFirst();
                deque.addLast(i);
            }
            list.add(num[deque.peekFirst()]);
        }
        return list;
    }
	
}
