package Algorithm.Offer.AllProblems;

import java.util.ArrayList;
import java.util.Stack;

import Algorithm.Offer.TreeNode;

/**
 * 二叉树中和为某一值的路径
 * @author Administrator
 *
 */
public class Problem34 {

//	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//        if(root==null) return list;
//        Stack<Integer> path = new Stack<Integer>();
//        int currentSum = 0;
//        FindPath(list,root,target,path,currentSum);
//        return list;
//    }
//	
//	public void FindPath(ArrayList<ArrayList<Integer>> list,TreeNode root,int target,Stack<Integer> path,int currentSum){
//		ArrayList<Integer> innerList = new ArrayList<Integer>();
//		currentSum += root.val;
//		path.add(root.val);
//		boolean isLeaf = root.left==null && root.right==null;
//		if(currentSum==target && isLeaf) {
//			Stack<Integer> stack = new Stack<Integer>();
//			while(!path.isEmpty()) {
//				stack.push(path.pop());
//			}
//			while(!stack.isEmpty()) {
//				innerList.add(stack.peek());
//				path.push(stack.pop());
//			}
//			list.add(innerList);
//		}		
//		if(root.left!=null) FindPath(list,root.left,target,path,currentSum);
//		if(root.right!=null) FindPath(list,root.right,target,path,currentSum);		
//		path.pop();
//	}
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        FindPath(list,new ArrayList<>(),root,target,0);
        return list;
    }
    private static void FindPath(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, TreeNode root,int target, int currentSum){
        currentSum += root.val;
        tempList.add(root.val);
        if(root.left==null && root.right==null && currentSum==target) list.add(new ArrayList<Integer>(tempList));
        if(root.left!=null) FindPath(list,tempList,root.left,target,currentSum);
        if(root.right!=null) FindPath(list,tempList,root.right,target,currentSum);
        tempList.remove(tempList.size()-1);
    }
	
}
