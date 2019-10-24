package Algorithm.Offer.AllProblems;

import java.util.HashMap;
import java.util.Map;

import Algorithm.Offer.ListNode;

/**
 * 两个链表的第一个公共节点
 * @author Administrator
 *
 */
public class Problem52 {
	
	//借助链表有公共节点的特点，先将长链表向前移动比短链表多出来的节点个数，然后将两个链表同步向前移动，直到遇到相同的节点为止
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		int length1 = ListNodeLength(pHead1);
		int length2 = ListNodeLength(pHead2);
		int length = length1-length2;
		ListNode pLongListNode = pHead1;
		ListNode pShortListNode = pHead2;
		if (length2>length1) {
			pLongListNode = pHead2;
			pShortListNode = pHead1;
			length = length2-length1;
		}
		for(int i=0;i<length;i++) {
			pLongListNode = pLongListNode.next;
		}
		while(pLongListNode!=null && pShortListNode!=null && pLongListNode!=pShortListNode) {
			pLongListNode = pLongListNode.next;
			pShortListNode = pShortListNode.next;
		}
		return pLongListNode;
	}
	
	public int ListNodeLength(ListNode listNode) {
		int length = 0;
		ListNode pNode = listNode;
		while(pNode!=null) {
			length++;
			pNode = pNode.next;
		}
		return length;
	}
	
	//借助哈希表来完成
	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode pNode = null;
        if(pHead1==null || pHead2==null) return pNode;
        Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
        for(pNode=pHead1;pNode!=null;pNode=pNode.next)
            map.put(pNode,1);
        for(pNode=pHead2;pNode!=null;pNode=pNode.next)
            if(map.containsKey(pNode))
                return pNode;
        return pNode;
    }

}
