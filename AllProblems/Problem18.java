package Algorithm.Offer.AllProblems;

import Algorithm.Offer.ListNode;

/**
 * 删除链表中重复的节点
 * @author Administrator
 *
 */
public class Problem18 {
	
	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println(a.next);
		System.out.println(b);
		System.out.println(d);
		e.next = null;
		deletcDuplication(a);
		System.out.println(a.next);
		System.out.println(d);
		
		int[] array = new int[10];
		
		int length = array.length;
		
	}

	public static void deleteNode(ListNode ListHead,ListNode deleteNode) {
		if (ListHead==null || deleteNode==null) {
			return;
		}
		if (deleteNode.next!=null) {
			ListNode next = deleteNode.next;
			deleteNode.value = next.value;
			deleteNode.next = next.next;
			next = null;
		}else if (ListHead==deleteNode) {
			ListHead = null;
			deleteNode = null;
		}else {
			ListNode listNode = ListHead;
			while(listNode.next!=deleteNode) {
				listNode = listNode.next;
			}
			listNode.next = null;
			deleteNode = null;
		}
		
	}
	
	public static void deletcDuplication(ListNode pHead) {
		if(pHead==null) return;
		ListNode pPreNode = null;
		ListNode pNode = pHead;
		while(pNode!=null) {
			ListNode pNext = pNode.next;
			boolean needDelete = false;
			if (pNext!=null && pNext.value==pNode.value) needDelete = true;
			if(!needDelete) {
				pPreNode = pNode;
				pNode = pNode.next;
			}else {
				int val = pNode.value;
				ListNode pToBeDel = pNode;
				while(pToBeDel.next!=null && pToBeDel.value==val) {
					pNext = pToBeDel.next;
					pToBeDel = null;
					pToBeDel = pNext;
				}
				if(pPreNode==null) {
					pHead = pNext;
				}else {
					pPreNode.next = pNext;
				}
				pNode = pNext;
			}
		}
	}
	
	
	public static void deletcDuplication02(ListNode pHead) {
		if(pHead==null) return;
		ListNode pPreNode = null;
		ListNode pNode = null;
		while(pNode!=null) {
			ListNode pNext = pNode.next;
			boolean needDelete = false;
			if (pNext!=null && pNext.value == pNode.value) needDelete = true;
			if (!needDelete) {
				pPreNode = pNode;
				pNode = pNode.next;
			}else {
				int value = pNode.value;
				ListNode pToDel = pNode;
				while(pToDel.next!=null && pToDel.value==value) {
					pNext = pToDel.next;
					pToDel = null;
					pToDel = pNext;
				}
				if (pPreNode==null) {
					pHead = pNext;
				}else {
					pPreNode.next = pNext;
				}
				pNode = pNext;
			}
		}
		
	}
	
	public static ListNode deletcDuplication03(ListNode pHead) {
		if(pHead==null) return null;
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while(pNode!=null){
            ListNode pNext = pNode.next;
            boolean needToDel = false;
            if(pNext!=null && pNode.value==pNext.value) 
                needToDel = true;
            if(!needToDel){
                pPreNode = pNode;
                pNode = pNode.next;
            }else{
                int value = pNode.value;
                ListNode delNode = pNode;
                while(delNode!=null && delNode.value==value){
                    pNext = delNode.next;
                    delNode = null;
                    delNode = pNext;
                }
                if(pPreNode==null){
                    pHead = pNext;
                }else{
                    pPreNode.next = pNext;
                }
                pNode = pNext;
            }
        }
        return pHead;
	}
	
}