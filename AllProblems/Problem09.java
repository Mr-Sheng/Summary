package Algorithm.Offer.AllProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem09 {

	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	
	static Queue<Integer> queue1 = new LinkedList<Integer>();
	static Queue<Integer> queue2 = new LinkedList<Integer>();
	
	//两个栈实现队列
	public static void pushQueue(int value) {
		while(!stack1.isEmpty())
			stack2.push(stack1.pop());
		stack1.push(value);
		while(!stack2.isEmpty())
			stack1.push(stack2.pop());
	}
	
	public static int popQueue() {
		if (!stack1.isEmpty()) {
			int x = stack1.pop();
			return x;
		}
		return -1;
	}
	
	//两个队列实现栈
	public static void pushStack(int value) {
		queue2.add(value);
		while(!queue1.isEmpty())
			queue2.add(queue1.poll());
		while(!queue2.isEmpty())
			queue1.add(queue2.poll());
	}
	
	public static int popStack() {
		if (!queue1.isEmpty()) {
			int x = queue1.poll();
			return x;
		}
		return -1;
	}
	
}
