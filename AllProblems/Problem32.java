package Algorithm.Offer.AllProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Algorithm.Offer.TreeNode;

public class Problem32 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		TreeNode left1 = new TreeNode(3);
		TreeNode right1 = new TreeNode(4);
		TreeNode left2 = new TreeNode(5);
		TreeNode right2 = new TreeNode(6);
		root.left = left;
		root.right = right;
		left.left = left1;
		left.right = right1;
		right.left = left2;
		right.right = right2;
		left1.left = null;
		left1.right = null;
		right1.left = null;
		right1.right = null;
		left2.left = null;
		left2.right = null;
		right2.left = null;
		right2.right = null;
		PrintFromTopToBottom3(root);
	}

	//按照层序打印一棵二叉树
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.peek()!=null){
            if(queue.peek().left!=null) queue.add(queue.peek().left);
            if(queue.peek().right!=null) queue.add(queue.peek().right);
            list.add(queue.poll().val);
        }
        return list;
    }
	
	//按照层序打印二叉树，每一层打印完后要换行
	public static void PrintFromTopToBottom2(TreeNode root) {
		if(root==null) return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int nextLevel = 0;
		int toBePrint = 1;
		while(queue.peek()!=null) {
			System.out.print(queue.peek().val);
			if (queue.peek().left!=null) {
				queue.add(queue.peek().left);
				++nextLevel;
			}
			if (queue.peek().right!=null) {
				queue.add(queue.peek().right);
				++nextLevel;
			}
			queue.poll();
			--toBePrint;
			if (toBePrint==0) {
				System.out.println();
				toBePrint = nextLevel;
				nextLevel=0;
			}
		}
	}
	
	//按照“之”字型打印二叉树
	public static void PrintFromTopToBottom3(TreeNode root) {
		if(root==null) return;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		int nextLevel = 0;
		int toBePrint = 1;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				System.out.print(stack1.peek().val);
				if(stack1.peek().left!=null) {
					stack2.push(stack1.peek().left);
					++nextLevel;
				}
				if(stack1.peek().right!=null) {
					stack2.push(stack1.peek().right);
					++nextLevel;
				}
				stack1.pop();
				--toBePrint;
				if (toBePrint==0) {
					System.out.println();
					toBePrint = nextLevel;
					nextLevel = 0;
				}
			}
			while (!stack2.isEmpty()) {
				System.out.print(stack2.peek().val);
				if(stack2.peek().right!=null) {
					stack1.push(stack2.peek().right);
					++nextLevel;
				}
				if(stack2.peek().left!=null) {
					stack1.push(stack2.peek().left);
					++nextLevel;
				}
				stack2.pop();
				--toBePrint;
				if (toBePrint==0) {
					System.out.println();
					toBePrint = nextLevel;
					nextLevel = 0;
				}
			}
		}
	}
	
}
