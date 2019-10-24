package Algorithm.Offer.AllProblems;

import Algorithm.Offer.TreeNode;

/**
 * 重构二叉树
 * @author Administrator
 *
 */
public class Problem07 {
	
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		reConstructBinaryTree(pre,in);
		System.out.println();
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++) {
        	if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+(i-startIn),in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,(i-startIn)+(startPre+1),endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }
	
}