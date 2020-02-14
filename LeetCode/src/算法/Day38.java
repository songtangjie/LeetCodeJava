package 算法;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Day38 {
	/* 
	 * 中序右到左遍历
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int kthLargest(TreeNode root, int k) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
        	//先遍历右子树入栈
			while (cur != null) {
				stack.push(cur);
				cur = cur.right;
			}
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.left;
		}
        return result.get(k-1);
    }
}
