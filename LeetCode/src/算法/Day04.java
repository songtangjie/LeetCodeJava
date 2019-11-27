package 算法;

import java.util.LinkedList;
import java.util.Queue;

public class Day04 {
	//用于记录前一个值
	private Integer last;
	//中序遍历树，比较值
	public boolean isValidBST(TreeNode root) 
	{
		if (root == null) return true;
		
		if (!isValidBST(root.left)) return false;
		
		if (last != null && root.val <= last) return false;
		last = root.val;
		
		if (!isValidBST(root.right)) return false;
		
		return true;
	}
	
	//前序遍历树，上下界比较值
	public boolean isValidBST2(TreeNode root) 
	{
		if (root == null) return true;
			
		return isValidBST2(root, null, null);
	}
	
	public boolean isValidBST2(TreeNode root, Integer min, Integer max) 
	{
		if (root == null) return true;
		
		//先判断自己
		if (min != null && root.val <= min) return false;
		if (max != null && root.val >= max) return false;
		
		//判断左节点
		if (!isValidBST2(root.left, min, root.val)) return false;
		//判断右节点
		if (!isValidBST2(root.right, root.val, max)) return false;
		
		return true;
	}
	
	//层序遍历树，上下界比较值
	public boolean isValidBST3(TreeNode root) 
	{
		if (root == null) return true;
				
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> mins = new LinkedList<>();
		Queue<Integer> maxs = new LinkedList<>();
		
		nodes.offer(root);
		mins.offer(null);
		maxs.offer(null);
		
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			Integer min = mins.poll();
			Integer max = maxs.poll();
			
			if (min != null && node.val <= min) return false;
			if (max != null && node.val >= max) return false;
			
			if (node.left != null) {
				nodes.offer(node.left);
				mins.offer(min);
				maxs.offer(node.val);
			}
			
			if (node.right != null) {
				nodes.offer(node.right);
				mins.offer(node.val);
				maxs.offer(max);
			}
		}
		
		return true;
	}
}
