package Algorithm.Offer.AllProblems;

import java.util.LinkedList;
import java.util.Stack;

import Algorithm.Offer.TreeNode;

/**
 * 二叉搜索树中第k大节点
 * @author Administrator
 *
 */
public class Problem54 {

	public TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null || k<=0) return null;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list = InOrderTraversal(pRoot,list);
        if(k>list.size()) return null;
        return list.get(k-1);
    }
    
    public LinkedList<TreeNode> InOrderTraversal(TreeNode pRoot,LinkedList<TreeNode> list){
        if(pRoot.left!=null) InOrderTraversal(pRoot.left,list);
        list.add(pRoot);
        if(pRoot.right!=null) InOrderTraversal(pRoot.right,list);
        return list;
    }
    
    int index = 0;
    public TreeNode KthNode2(TreeNode pRoot, int k){
        if(pRoot!=null){
            TreeNode pNode = KthNode2(pRoot.left,k);
            if(pNode!=null) return pNode;
            index++;
            if(index==k) return pRoot;
            pNode = KthNode2(pRoot.right,k);
            if(pNode!=null) return pNode;
        }
        return null;
    }
    
    public TreeNode KthNode3(TreeNode pRoot, int k){
        TreeNode node = null;
        if(pRoot!=null && k>0){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pNode = pRoot;
            int count = 0;
            while(pNode!=null || !stack.isEmpty()){
                if(pNode!=null){
                    stack.push(pNode);
                    pNode = pNode.left;
                }else{
                    count++;
                    if(count==k){
                        node = stack.peek();
                        break;
                    }
                    pNode = stack.pop().right;
                }
            }
        }
        return node;
    }
	
}
