package 树;
import common.TreeNode;

public class _236_二叉树的最近公共祖先 {
	/* 
	 * 遍历
	 * ① 如果p、q同时存在于这棵二叉树中，就能成功返回它们的最近公共祖先
     * ② 如果p、q都不存在于这棵二叉树中，返回null
     * ③ 如果只有p存在于这棵二叉树中，返回p
     * ④ 如果只有q存在于这棵二叉树中，返回q
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if (root == null || root == p || root == q) return root;
		 
		 //左子树
		 TreeNode left = lowestCommonAncestor(root.left, p, q);
		 //右子树
		 TreeNode right = lowestCommonAncestor(root.right, p, q);
		 
		 if (left != null && right != null) return root;
		 return (left != null) ? left : right;
	 }
}
