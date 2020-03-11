package 栈_队列;

import java.util.Stack;

public class _232_用栈实现队列 {
	/* 
	 * 双栈
	 */	
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	private int front;
	
	/** Initialize your data structure here. */
    public _232_用栈实现队列() {
    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	//如果栈空则队头元素赋值给front
    	if (stack1.isEmpty()) front = x;
    	//直接压栈
    	stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	//如果第二个栈空则从第一个站压栈过来，顺序已变好
    	if (stack2.isEmpty()) {
        	while (!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
		}
    	return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	//如果第二个栈不为空则队头直接取
    	if (!stack2.isEmpty()) return stack2.peek();
    	return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	//两个栈都存有元素
    	return stack1.isEmpty() && stack2.isEmpty();
    }
}
