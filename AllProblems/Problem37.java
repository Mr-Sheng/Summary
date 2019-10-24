package Algorithm.Offer.AllProblems;

import Algorithm.Offer.TreeNode;

/**
 * 序列化二叉树
 * @author Administrator
 *
 */
public class Problem37 {
	
	int index = -1;

	public String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if (root==null) {
			sb.append("$,");
			return sb.toString();
		}
		sb.append(root.val);
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
	
	public TreeNode Deserialize(String str) {
		index++;
		String[] strr = str.split(",");
		TreeNode node = null;
		if (!strr[index].equals("$")) {
			node = new TreeNode(Integer.valueOf(strr[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
	
}
