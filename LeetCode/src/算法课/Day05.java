package 算法课;

public class Day05
{
	//最小整数值
	private int sum = Integer.MIN_VALUE;
	
	//求出经过某个节点的最大路径值
	private int nodeValue(TreeNode node)
	{
		if (node == null) return 0;
		
		//后序遍历树
		int leftValue = Math.max(nodeValue(node.left), 0);
		int rightValue = Math.max(nodeValue(node.right), 0);
		//比较经过该点左右节点路径的值
		sum = Math.max(sum, node.val + leftValue + rightValue);
		return node.val + Math.max(leftValue, rightValue);
	}
	
	public int maxPathSum(TreeNode root)
	{
        return Math.max(this.nodeValue(root), sum);
    }
}
