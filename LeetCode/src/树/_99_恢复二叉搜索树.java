package 树;

import common.TreeNode;

public class _99_恢复二叉搜索树 {
    /**
     * 上一次中序遍历过的节点
     */
    private TreeNode prev;
    /**
     * 第一个错误节点
     */
    private TreeNode first;
    /**
     * 第二个错误节点
     */
    private TreeNode second;
    
	/* 
	 * 中序遍历找逆序对，取最大值和最小值
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public void recoverTree(TreeNode root) {
    	findWrongNodes(root);
    	//交换错误的节点的值
    	int temp = first.val;
    	first.val = second.val;
    	second.val = temp;
    }
    
    //递归查找节点
    private void findWrongNodes(TreeNode root) {
    	if (root == null) return;
    	findWrongNodes(root.left);
    	find(root);
    	findWrongNodes(root.right);
    }
    
    //查找节点处理逆序对
    private void find(TreeNode node) {
    	//找到逆序对
		if (prev != null && prev.val > node.val) {
			//赋值较小的逆序节点
			second = node;
			//如果前一个逆序对较大的值找到
			if (first != null) return;
			//赋值较大的逆序节点
			first = prev;
		}
		prev = node;
	}
}
