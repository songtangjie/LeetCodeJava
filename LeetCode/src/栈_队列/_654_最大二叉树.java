package 栈_队列;

import java.util.Arrays;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class _654_最大二叉树 {
    /* 
	 * 确定左闭右开区间内最大值，递归构造数
	 * 时间复杂度:O(n^2)，空间复杂度:O(n)
	 */	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	if (nums == null) return null;
    	return findRoot(nums, 0, nums.length);
    }
    
    private TreeNode findRoot(int[] nums, int l, int r) {
    	if (l == r) return null;
    	//找到范围内最大值索引
    	int maxIndex = l;
    	for (int i = l+1; i < r; i++) {
			if (nums[i] > nums[maxIndex]) maxIndex = i;
		}
    	
    	TreeNode root = new TreeNode(nums[maxIndex]);
    	root.left = findRoot(nums, l, maxIndex);
    	root.right = findRoot(nums, maxIndex+1, r);
    	return root;
	}
    
    /* 
	 * 利用栈求出节点的父节点
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] parentIndexes(int[] nums) {
    	if (nums == null || nums.length == 0) return null;
    	int[] lis = new int[nums.length];
    	int[] ris = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
			lis[i] = -1;
			ris[i] = -1;
		}
    	//构造栈，保持栈底到栈顶是单调递减的
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				ris[stack.pop()] = i;
			}
			if (!stack.isEmpty()) {
				lis[i] = stack.peek();
			}
			stack.push(i);
		}
    	
    	int[] pis = new int[nums.length];
    	for (int i = 0; i < pis.length; i++) {
    		//自己是最大值
			if (lis[i] == -1 && ris[i] == -1) {
				pis[i] = -1;
				continue;
			}
			
			if (lis[i] == -1) {
				pis[i] = ris[i];
			} else if (ris[i] == -1) {
				pis[i] = lis[i];
			} else {
				pis[i] = nums[lis[i]] < nums[ris[i]] ? lis[i] : ris[i];
			}
		}
    	return pis;
    }
    
    public static void main(String[] args) {
    	_654_最大二叉树 o = new _654_最大二叉树();
    	int[] nums = { 3, 2, 1, 6, 0, 5 };
    	System.out.println(Arrays.toString(o.parentIndexes(nums)));
	}
}
