package Algorithm.Offer.AllProblems;

import Algorithm.Offer.BinaryTree;

/**
 *  树的子结构
 * @author Administrator
 *
 */
public class Problem26 {

	public static void main(String[] args) {
		
	}
	
	public boolean HasSubtree(BinaryTree root1,BinaryTree root2) {
		boolean result = false;
		if (root1!=null && root2!=null) {
			if (root1.value==root2.value) result = DoesTree1HasTree2(root1,root2);
			if (!result) result = HasSubtree(root1.left, root2);
			if (!result) result = HasSubtree(root1.right, root2);
		}
		return result;
	}
	
	public boolean DoesTree1HasTree2(BinaryTree root1,BinaryTree root2){
		if(root2==null) return true;
		if(root1==null) return false;
		if(root1.value!=root2.value) return false;
		return DoesTree1HasTree2(root1.left,root2.left) && DoesTree1HasTree2(root1.right,root2.right);
	}
	
	
	
}
