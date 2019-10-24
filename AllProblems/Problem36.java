package Algorithm.Offer.AllProblems;

import java.util.Stack;

import Algorithm.Offer.TreeNode;

/**
 * 二叉搜索树与双向链表
 * @author Administrator
 *
 */
public class Problem36 {
	
	TreeNode leftHead = null;
	TreeNode rightHead = null;

	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null) return null;
		Convert(pRootOfTree.left);
		if(rightHead==null) {
			rightHead = pRootOfTree;
			leftHead = pRootOfTree;
		}else {
			rightHead.right = pRootOfTree;
			pRootOfTree.left = rightHead;
			rightHead = pRootOfTree;
		}
		Convert(pRootOfTree.right);
		return leftHead;
	}
	
	public TreeNode Convert2(TreeNode pRootOfTree) {
		if(pRootOfTree==null) return null;
		if(pRootOfTree.left==null && pRootOfTree.right==null) return pRootOfTree;
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode leftNode = left;
		while(leftNode!=null &&leftNode.right!=null)
			leftNode = leftNode.right;
		if(left!=null) {
			leftNode.right = pRootOfTree;
			pRootOfTree.left = leftNode;
		}
		TreeNode right = Convert(pRootOfTree.right);
		if(right!=null) {
			pRootOfTree.right = right;
			right.left = pRootOfTree;
		}
		return left!=null ? left : pRootOfTree;
	}
	
	public TreeNode Convert3(TreeNode pRootOfTree) {
		if(pRootOfTree==null) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pNode = pRootOfTree;
		TreeNode pHead = null;
		TreeNode preNode = null;
		boolean isFirst = true;
		while(pNode!=null || !stack.isEmpty()) {
			while(pNode!=null) {
				stack.push(pNode);
				pNode = pNode.left;
			}
			pNode = stack.pop();
			if(isFirst) {
				pHead = pNode;
				preNode = pNode;
				isFirst = false;
			}else {
				preNode.right = pNode;
				pNode.left = preNode;
				preNode = pNode;
			}
			pNode = pNode.right;
		}
		return pHead;
	}
	
	
	
}
