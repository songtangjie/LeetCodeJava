package 树;
import common.TreeNode;

public class _333_最大BST子树 {
	
	/**
     * 最大BST子树的信息
     */
    private static class Info {
        /** 根节点 */
        public TreeNode root;
        /** 节点总数 */
        public int size = 1;
        /** 最大值 */
        public int max;
        /** 最小值 */
        public int min;
        public Info(TreeNode root, int size, int max, int min) {
            this.root = root;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
	
    /* 
	 * 自底向上遍历，减少重复遍历
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
	public int largestBSTSubtree(TreeNode root) {
        return (root == null) ? 0 : getInfo(root).size;
    }
	
	private Info getInfo(TreeNode root) {
		Info li = null,ri = null;
		//递归遍历
		if (root.left != null) li = getInfo(root.left);
		if (root.right != null) ri = getInfo(root.right);
		
		// ls >= 0 说明左子树可以跟root组成二叉搜索树
		int ls = -1,min = root.val;
		if (li == null) {
			ls = 0;
		} else if (li.root == root.left && li.max < root.val) {
			ls = li.size;
			min = li.min;
		}
		
		// rs >= 0 说明右子树可以跟root组成二叉搜索树
		int rs = -1,max = root.val;
		if (ri == null) {
			rs = 0;
		} else if (ri.root == root.right && ri.min > root.val) {
			rs = ri.size;
			max = ri.max;
		}
		
		// root是二叉搜索树
		if (rs >= 0 && ls >= 0) return new Info(root, 1+rs+ls, max, min);
		// 返回数量较多的信息
		if (li != null && ri != null) return (li.size > ri.size) ? li : ri;
		// 左右子树有一个为null
		return (li != null) ? li : ri;
	}
}
