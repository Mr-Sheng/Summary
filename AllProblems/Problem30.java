package Algorithm.Offer.AllProblems;

import java.util.Stack;

public class Problem30 {

	private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min_stack = new Stack<Integer>();

    /** initialize your data structure here. */
    public Problem30() {
        
    }
    
    public void push(int x) {
        
        stack.push(x);
        
        if(min_stack.isEmpty()){
            min_stack.push(x);
        }else {
            if(x>=min_stack.peek()){
                int temp = min_stack.peek();
                min_stack.push(temp);
            }else{
                min_stack.push(x);
            }
        }
    }
    
    public void pop() {
        stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
