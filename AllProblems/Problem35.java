package Algorithm.Offer.AllProblems;

import Algorithm.Offer.RandomListNode;

/**
 * 复杂链表的复制
 * @author Administrator
 *
 */
public class Problem35 {

	public RandomListNode Clone(RandomListNode pHead){
        CloneNodes(pHead);
        ConnectSiblingNodes(pHead);
        return ReconnectNodes(pHead);
    }
    
    public void CloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode pCloned = new RandomListNode(0);
            pCloned.label = pNode.label;
            pCloned.random = null;
            pCloned.next = pNode.next;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }
    
    public void ConnectSiblingNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode pCloned = pNode.next;
            if(pNode.random!=null){
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }
    
    public RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if(pNode!=null){
            pClonedHead = pNode.next;
            pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while(pNode!=null){
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }
	
}
