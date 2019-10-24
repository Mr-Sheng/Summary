package Algorithm.Offer.AllProblems;

import Algorithm.Offer.TreeNode;

/**
 * 二叉树的深度
 * @author Administrator
 *
 */
public class Problem55 {

	//二叉树的深度
	public int TreeDepth(TreeNode root) {
        if(root==null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return (left>right) ? (left+1):(right+1);
    }
	
	//判断二叉树是不是平衡二叉树
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        int diff = left-right;
        if(diff>1||diff<-1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
	
}
