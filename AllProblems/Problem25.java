package Algorithm.Offer.AllProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

import Algorithm.Offer.ListNode;

/**
 * 合并两个排序列表
 * @author Administrator
 *
 */
public class Problem25 {
	
	public static void main(String[] args) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(10,new Comparator<ListNode>() {
			@Override
			public int compare(ListNode list1, ListNode list2) {
				return list1.value-list2.value;
			}
		});
	}

	//
	public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode newList = null;
        if(list1.value<list2.value){
            newList = list1;
            newList.next = Merge(list1.next,list2);
        }else{
            newList = list2;
            newList.next = Merge(list1,list2.next);
        }
        return newList;
    }
	
	//递归实现两个排序链表合并
	public static ListNode MergeList(ListNode list1,ListNode list2) {
		if (list1==null) {
			return list2;
		}else if (list2==null) {
			return list1;
		}
		ListNode newList = null;
		if (list1.value<list2.value) {
			newList = list1;
			newList.next = MergeList(list1.next, list2);
		}else {
			newList = list2;
			newList.next = MergeList(list1, list2.next);
		}
		return newList;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length<1) return null;
		int len = lists.length;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(len, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode list1, ListNode list2) {
				return list1.value-list2.value;
			}
		});
		for(int i=0;i<len;i++)
			if(lists[i]!=null)
				queue.add(lists[i]);
		ListNode head = new ListNode(0);
		ListNode pNode = head;
		while(!queue.isEmpty()) {
			ListNode tempNode = queue.poll();
			if(tempNode.next!=null) queue.add(tempNode.next);
			pNode.next = tempNode;
			pNode = pNode.next;
		}
		return head.next;
	}
	
	public ListNode mergeKLists2(ListNode[] lists) {
		if(lists==null || lists.length<1) return null;
		return mergeKListsByDividedAndMerge(lists,0,lists.length);
	}
	
	private ListNode mergeKListsByDividedAndMerge(ListNode[] lists, int left, int right) {
		ListNode list1;
		ListNode list2;
		if(left==right) {
			return lists[left];
		}else {
			int mid = (left+right)/2;
			list1 = mergeKListsByDividedAndMerge(lists,left,mid);
			list2 = mergeKListsByDividedAndMerge(lists,mid+1,right);
		}
		
		if(list2==null) {
			return list1;
		}else if(list1==null) {
			return list2;
		}
		
		ListNode head = new ListNode(0);
		ListNode pNode = head;
		while(list1!=null && list2!=null) {
			if(list1.value<list2.value) {
				pNode.next = list1;
				list1 = list1.next;
			}else {
				pNode.next = list2;
				list2 = list2.next;
			}
			pNode = pNode.next;
		}
		return head.next;
	}
	
}
