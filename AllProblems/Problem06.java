package Algorithm.Offer.AllProblems;

import java.util.ArrayList;
import java.util.Stack;

import Algorithm.Offer.ListNode;

/**
 * 从尾到头打印链表
 * @author Administrator
 *
 */
public class Problem06 {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(listNode!=null){
            stack.push(listNode.value);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()) list.add(stack.pop());
        return list;
    }
	
}
