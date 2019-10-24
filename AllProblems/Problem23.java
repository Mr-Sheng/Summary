package Algorithm.Offer.AllProblems;

import Algorithm.Offer.ListNode;

/**
 * 链表中环的入口节点
 * @author Administrator
 *
 */
public class Problem23 {
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = c;
		System.out.println(meetingNode(a));
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
	
	
	public static ListNode MeetingNode(ListNode head) {
		if(head==null) return null;
		ListNode pNode1 = head;
		ListNode pNode2 = head;
		int nodeNum = 0;
		while(pNode1.next!=null && pNode1.next.next != null) {
			pNode1 = pNode1.next.next;
			pNode2 = pNode2.next;
			if (pNode1==pNode2) {
				while(pNode2.next!=pNode1) {
					++nodeNum;
					pNode2 = pNode2.next;
				}
				++nodeNum;
				break;
			}
		}
		
		if (nodeNum==0) {
			return null;
		}else {
			ListNode pNode11 = head;
			ListNode pNode22 = head;
			while(nodeNum-->0) {
				pNode11 = pNode11.next;
			}
			while(pNode11!=pNode22) {
				pNode11 = pNode11.next;
				pNode22 = pNode22.next;
			}
			return pNode11;
		}
	}
	
	public static ListNode meetingNode(ListNode head) {
		if(head==null) return null;
		ListNode fastNode = head;
		ListNode slowNode = head;
		int nodeNum = 0;
		while(fastNode.next!=null && fastNode.next.next!=null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if (fastNode==slowNode) {
				while(fastNode.next!=slowNode) {
					++nodeNum;
					fastNode = fastNode.next;
				}
				++nodeNum;
				break;
			}
		}
		
		if(nodeNum==0) {
			return null;
		}else {
			ListNode beforeNode = head;
			ListNode afterNode = head;
			while(nodeNum-->0) {
				beforeNode = beforeNode.next;
			}
			while(beforeNode!=afterNode) {
				beforeNode = beforeNode.next;
				afterNode = afterNode.next;
			}
			return beforeNode;
		}
	}
	
	
}


//if(pHead==null) return null;
//ListNode slowNode = pHead;
//ListNode fastNode = pHead;
//int nodeNum = 0;
//while(fastNode.next!=null && fastNode.next.next!=null){
//    slowNode = slowNode.next;
//    fastNode = fastNode.next.next;
//    if(slowNode==fastNode){
//        while(slowNode.next!=fastNode){
//            ++nodeNum;
//            slowNode = slowNode.next;
//        }
//        ++nodeNum;
//        break;
//    }
//}
//if(nodeNum==0){
//    return null;
//}else{
//    ListNode pNode1 = pHead;
//    ListNode pNode2 = pHead;
//    while(nodeNum-->0){
//        pNode1 = pNode1.next;
//    }
//    while(pNode1!=pNode2){
//        pNode1 = pNode1.next;
//        pNode2 = pNode2.next;
//    }
//    return pNode1;
//}
//}