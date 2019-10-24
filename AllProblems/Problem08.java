package Algorithm.Offer.AllProblems;

public class Problem08 {
	
	public static void main(String[] args) {
		BinaryTreeNode a = new BinaryTreeNode(1);
		BinaryTreeNode b = new BinaryTreeNode(2);
		BinaryTreeNode c = new BinaryTreeNode(3);
		BinaryTreeNode d = new BinaryTreeNode(4);
		a.parentNode = null;
		a.leftNode = b;
		a.rightNode = c;
		
		b.parentNode = a;
		b.leftNode = d;
		b.rightNode = null;
		
		c.parentNode = a;
		c.leftNode = null;
		c.rightNode = null;
		
		d.parentNode = b;
		d.leftNode = null;
		d.rightNode = null;
		
		System.out.println(getNext(c));
		System.out.println(b);
		
	}

//	public static BinaryTreeNode getNext(BinaryTreeNode pNode) {
//		if (pNode==null) {
//			return null;
//		}
//		BinaryTreeNode pNext = null;
//		if(pNode.rightNode!=null) {
//			BinaryTreeNode pRight = pNode.rightNode;
//			while(pRight.leftNode!=null)
//				pRight = pRight.leftNode;
//			pNext = pRight;
//		}else if (pNode.parentNode!=null) {
//			BinaryTreeNode pCurrent = pNode;
//			BinaryTreeNode pParent = pNode.parentNode;
//			while(pParent!=null && pCurrent==pParent.rightNode) {
//				pCurrent = pParent;
//				pParent = pParent.parentNode;
//			}
//			pNext = pParent;
//		}
//		return pNext;
//	}
	
	
	public static BinaryTreeNode getNext(BinaryTreeNode pNode) {
		if (pNode==null) {
			return null;
		}
		BinaryTreeNode pNext = null;
		if (pNode.rightNode!=null) {
			BinaryTreeNode pRight = pNode.rightNode;
			while(pRight.leftNode!=null)
				pRight = pRight.leftNode;
			pNext = pRight;
		}else if (pNode.parentNode!=null) {
			BinaryTreeNode pCurrent = pNode;
			BinaryTreeNode pParent = pNode.parentNode;
			while(pParent!=null && pCurrent==pParent.rightNode) {
				pCurrent = pParent;
				pParent = pParent.parentNode;
			}
			pNext = pParent;
		}
		return pNext;
	}
	
	
//	if(pNode==null) return null;
//    TreeLinkNode pNext = null;
//    if(pNode.right!=null){
//        pNext = pNode.right;
//        while(pNext.left!=null)
//            pNext = pNext.left;
//    }else if(pNode.next!=null){
//        TreeLinkNode pCurrent = pNode;
//        TreeLinkNode pParent = pNode.next;
//        while(pParent!=null && pCurrent==pParent.right){
//            pCurrent = pParent;
//            pParent = pParent.next;
//        }
//        pNext = pParent;
//    }
//    return pNext;
	
	
}

class BinaryTreeNode{
	int value;
	BinaryTreeNode parentNode;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
	BinaryTreeNode(int x) {value = x;}
}