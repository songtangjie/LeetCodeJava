package 栈_队列;

import java.util.Stack;

public class _面试题09_用两个栈实现队列 {
	/* 
	 * 第一个栈存储，第二个栈做辅助用，size用于记录队列长度
	 */	
	
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int size;
	
    public _面试题09_用两个栈实现队列() {
       	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    	size = 0;
    }
    
    public void appendTail(int value) {
    	//利用辅助栈保证加入元素在栈底，变fifo为lifo
    	while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
    	stack1.push(value);
    	while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
    	size++;
    }
    
    public int deleteHead() {
    	if (size == 0) {
			return -1;
		} else {
			size--;
			return stack1.pop();
		}
    }
}
