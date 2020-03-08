package 字符串;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _572_另一个树的子树 {
    /* 
	 * 后序遍历序列化树，非空节点:值!,空节点:#!
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	return postSerialize(s).contains(postSerialize(t));
    }
    
    //返回序列化的字符串
    private String postSerialize(TreeNode node) {
//    	StringBuilder sb = new StringBuilder("!");//前序遍历需要先拼接!,不然会有特殊字符导致匹配失败
    	StringBuilder sb = new StringBuilder();
		postSerialize(node, sb);
		return sb.toString();
	}
    
    //后续遍历序列化
    private void postSerialize(TreeNode node, StringBuilder sb) {
		if (node.left == null) {
			sb.append("#!");
		} else {
			postSerialize(node.left, sb);
		}
		
		if (node.right == null) {
			sb.append("#!");
		} else {
			postSerialize(node.right, sb);
		}
		
		sb.append(node.val).append("!");
	}
}
