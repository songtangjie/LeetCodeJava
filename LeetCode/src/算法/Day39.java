package 算法;

final class TreeInfo {
	  public final int height;
	  public final boolean balanced;

	  public TreeInfo(int height, boolean balanced) {
	    this.height = height;
	    this.balanced = balanced;
	  }
}

public class Day39 {
	/* 
	 * 自底向上递归，避免重复查询问题
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }
    
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
		if (root == null) {
			return new TreeInfo(-1, true);
		}
		
		TreeInfo left = isBalancedTreeHelper(root.left);
		if (!left.balanced) {
			return new TreeInfo(-1, false);
		}
		
		TreeInfo right = isBalancedTreeHelper(root.right);
		if (!right.balanced) {
			return new TreeInfo(-1, false);
		}
		
		if (Math.abs(left.height - right.height) < 2) {
			return new TreeInfo(Math.max(left.height, right.height)+1, true);
		}
		
		return new TreeInfo(-1, false);
	}
}
