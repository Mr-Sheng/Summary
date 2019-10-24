package Algorithm.Offer.AllProblems;

import java.util.Stack;

import Algorithm.Offer.ListNode;

/**
 * 反转链表
 * @author Administrator
 *
 */
public class Problem24 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode pNode = head;
		for(int i=1;i<=6;i++) {
			pNode.next = new ListNode(i+1);
			pNode=pNode.next;
		}
		
		ReverseList(head,3,5);
		
		for(int i=0;i<7;i++) {
			System.out.println(head.value);
			head = head.next;
		}
	}
	
	public static ListNode reverseListNode(ListNode head) {
		if(head==null) return null;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode pNode = head;
        while(pNode!=null){
            stack.push(pNode.value);
            pNode = pNode.next;
        }
        ListNode pNext = head;
        while(!stack.isEmpty()){
            pNext.value = stack.pop();
            pNext = pNext.next;
        }
        return head;
	}
	
	public static ListNode ReverseList(ListNode head) {
		if(head==null) return null;
		ListNode pReverseHead = null;
		ListNode pNode = head;
		ListNode pPreNode = null;
		while(pNode!=null) {
			ListNode pNext = pNode.next;
			if(pNext==null) pReverseHead = pNode;
			pNode.next = pPreNode;
			pPreNode = pNode;
			pNode = pNext;
		}
		return pReverseHead;
	}
	
	//3 5
	//1 2 3 4 5 6
	public static ListNode ReverseList(ListNode head,int m,int n) {
		if(head==null || m>n || m<1) throw new RuntimeException();
		
		ListNode pLeftNode = head;//pLeftNode首先定位到m-1的位置
		ListNode pLeftHead = head;//pLeftHead首先定位到pLeftNode的前一个位置，即m-2的位置
		for(int i=0;i<m-1;i++) {
			if(pLeftHead == null) throw new RuntimeException();
			pLeftHead = pLeftNode;
			pLeftNode = pLeftNode.next;
		}
		
		ListNode pRightNode = pLeftNode;//pRightNode首先定位到n-1的位置
		ListNode pRightHead = pLeftNode;//pRightHead首先定位到pRightNode的后一个位置，即n的位置
		for(int i=m-1;i<n;i++) {
			if(pRightNode==null) throw new RuntimeException();
			pRightNode = pRightHead;
			pRightHead = pRightHead.next;
		}
		
		ListNode pPreNode = pRightHead;
		while(pLeftNode!=pRightHead) {
			ListNode pNext = pLeftNode.next;
			if(pNext==pRightHead) pLeftHead.next = pLeftNode;
			pLeftNode.next = pPreNode;
			pPreNode = pLeftNode;
			pLeftNode = pNext;
		}
		return head;
	}
	
	
}
