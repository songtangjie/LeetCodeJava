package 算法;

import java.util.Stack;

public class Day01 {
	
    public int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	for (int i = 0; i < tokens.length; i++) {
			switch (tokens[i]) {
			case "+":
				stack.push(stack.pop() + stack.pop());
				break;
			case "-":
				stack.push(-stack.pop() + stack.pop());
				break;
			case "*":
				stack.push(stack.pop() * stack.pop());
				break;	
			case "/":
				Integer pre = stack.pop();
				stack.push(stack.pop() / pre);
				break;
			default:
				stack.push(Integer.valueOf(tokens[i]));
				break;
			}
		}
    	
        return stack.pop();
    }
}
