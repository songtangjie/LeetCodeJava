package 算法;

public class Day18 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if (s != null && t != null) {
        	if (s.val == t.val) {//值相等遍历子树
				result = doesTreeHaveTree2(s, t);
			}
        	if (!result) {//遍历左子树
				result = isSubtree(s.left, t);
			}
        	if (!result) {//遍历右子树
				result = isSubtree(s.right, t);
			}
		}
        return result;
    }
    
    private boolean doesTreeHaveTree2(TreeNode roo1, TreeNode roo2) {
		if (roo1 == null && roo2 == null) {//子树也完全一样
			return true;
		}
		
		if (roo1 == null || roo2 == null) {
			return false;
		}
		
		if (roo1.val != roo2.val) {
			return false;
		}
		return doesTreeHaveTree2(roo1.left, roo2.left) && doesTreeHaveTree2(roo1.right, roo2.right);
	}
}
