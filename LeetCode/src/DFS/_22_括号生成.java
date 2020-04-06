package DFS;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
	/* 
	 * DFS算法
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<String>();
    	if (n < 0) return list;
    	dfs(0, n, n, new char[n << 1], list);
    	return list;
    }
    
    private void dfs(int idx, int leftRemain, int rightRemain, char[] string, List<String> list) {
    	if (idx == string.length) {
			list.add(new String(string));
			return;
		}
    	
        // 枚举这一层所有可能的选择
        // 选择一种可能之后，进入下一层搜索

        // 什么情况可以选择左括号？左括号的数量 > 0
        // 选择左括号，然后进入下一层搜索
    	if (leftRemain > 0) {
			string[idx] = '(';
			dfs(idx+1, leftRemain-1, rightRemain, string, list);
		}
    	
        // 当左括号、右括号的数量一样时，只能选择左括号
        // 什么情况可以选择右括号？(右括号的数量 > 0) && (右括号的数量 != 左括号的数量)
        // 选择右括号，然后进入下一层搜索
    	if (rightRemain > 0 && leftRemain != rightRemain) {
    		string[idx] = ')';
			dfs(idx+1, leftRemain, rightRemain-1, string, list);
		}
    }
}
