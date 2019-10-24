package Algorithm.Offer.AllProblems;

import Algorithm.Offer.ListNode;

public class Problem22 {

	public static void main(String[] args) {
		
	}
	
	public static ListNode FindKthToTail(ListNode head,int k) {
		if(head==null || k==0) return null;
        ListNode pNode1 = head;
        ListNode pNode2 = head;
        for(int i=1;i<k;i++){
            if(pNode1.next!=null){
                pNode1 = pNode1.next;
            }else{
                return null;
            }
        }
        while(pNode1.next!=null){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode2;
	}
}