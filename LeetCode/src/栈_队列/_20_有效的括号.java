package 栈_队列;

import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {
	/* 
	 * 构造栈
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
	private HashMap<Character, Character> mappings;//映射表
	public _20_有效的括号() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put('}', '{');
		this.mappings.put(']', '[');
	}

    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	int n = s.length();
    	for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (mappings.containsKey(c)) {//映射表包含字符
				char toC = stack.empty() ? '#' : stack.pop();
				if (toC != mappings.get(c)) return false;
			} else {
				stack.push(c);
			}
		}
    	return stack.isEmpty();
    }
}
