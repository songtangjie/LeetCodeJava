package 栈_队列;

import java.util.Stack;

public class _42_接雨水 {
	/* 
	 * 构造栈存储每堵墙
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int trap(int[] height) {
    	if (height == null) return 0;
    	
    	int sum = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				//出栈的元素
				int h = height[stack.peek()];
				stack.pop();
				if (stack.isEmpty()) break;
				
				//计算距离
				int distance = i - stack.peek() - 1;
				//取比较小的墙（木桶原理）
				int minH = Math.min(height[i], height[stack.peek()]);
				sum += distance*(minH-h);
			}
			stack.push(i);
		}
    	return sum;
    }
}
