package 栈_队列;

import java.util.Stack;

public class _155_最小栈 {
	//数据栈
	Stack<Integer> stack;
	//辅助栈
	Stack<Integer> minStack;
	
	/* 
	 * 辅助栈存放，空间换时间
	 * 时间复杂度:O(1)，空间复杂度:O(n)
	 */	
    public _155_最小栈() {
    	stack = new Stack<Integer>();
    	minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if (minStack.isEmpty()) {
			minStack.push(x);
		} else {
			minStack.push(Math.min(x, minStack.peek()));
		}
    }
    
    public void pop() {
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
}
