package 算法;

import java.util.Stack;

public class Day22 {
	
	   // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;
	
	/* 
	 * 时间复杂度:O(1)，时间复杂度:O(n)
	 */	
    public Day22() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
    	data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
			helper.add(x);
		} else {
			helper.add(helper.peek());
		}
    }
    
    public void pop() {
        if (!data.isEmpty()) {
			data.pop();
			helper.pop();
		}
    }
    
    public int top() {
        if (!data.isEmpty()) {
			return data.peek();
		}
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
    
    public int getMin() {
        if (!helper.isEmpty()) {
			return helper.peek();
		}
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
