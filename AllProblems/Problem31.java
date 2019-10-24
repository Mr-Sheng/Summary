package Algorithm.Offer.AllProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem31 {

	public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null && popA==null) return true;
        if((pushA==null && popA!=null) || (pushA!=null && popA==null)) return false;
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> pushQueue = new LinkedList<Integer>();
        Queue<Integer> popQueue = new LinkedList<Integer>();
        for(int i=0;i<pushA.length;i++){
            pushQueue.add(pushA[i]);
        }
        for(int i=0;i<popA.length;i++){
            popQueue.add(popA[i]);
        }
        while(!pushQueue.isEmpty()){
            stack.push(pushQueue.poll());
            while((!popQueue.isEmpty()) && (!stack.isEmpty()) && (popQueue.peek()==stack.peek())){
                popQueue.poll();
                stack.pop();
            }
        }
        if(popQueue.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
	
}
