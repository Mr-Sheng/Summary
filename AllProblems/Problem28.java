package Algorithm.Offer.AllProblems;

import Algorithm.Offer.TreeNode;

/**
 * 判断是否为对称二叉树
 * @author Administrator
 *
 */
public class Problem28 {
	
	public static void main(String[] args) {
		
	}

	public static boolean isSymmetrical(TreeNode root) {
		return isSymmetrical(root,root);
	}
	
	public static boolean isSymmetrical(TreeNode root1,TreeNode root2) {
		if(root1==null && root2==null) return true;
		if(root1==null || root2==null) return false;
		if(root1.val!=root2.val) return false;
		return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
	}
	
}
