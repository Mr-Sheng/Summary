package Algorithm.Offer.AllProblems;

import Algorithm.Offer.TreeNode;

/**
 * 二叉树镜像
 * @author Administrator
 *
 */
public class Problem27 {
	
	public static void main(String[] args) {
		
	}

	public static void Mirror(TreeNode root) {
		if(root==null) return;
		if(root.left==null && root.right==null) return;
		
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		
		if(root.left!=null) Mirror(root.left);
		if(root.right!=null) Mirror(root.right);
	}
	
}
