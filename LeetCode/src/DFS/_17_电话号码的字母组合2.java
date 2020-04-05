package DFS;

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码的字母组合2 {
	//映射关系
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    
	/* 
	 * DFS算法【局部变量形式】
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public List<String> letterCombinations(String digits) {
    	if (digits == null) return null;
    	List<String> list = new ArrayList<String>();
    	char[] chars = digits.toCharArray();
    	if (chars.length == 0) return list;
    	char[] string = new char[chars.length];
        dfs(0, chars, string, list);
        return list;
    }
    
    //dfs递归
    private void dfs(int idx, char[] chars, char[] string, List<String> list) {
    	// 已经进入到最后一层了，不能再往下搜索
		if (idx == chars.length) {
			//得到一个解
			list.add(new String(string));
			return;
		}
		
		//枚举这层所有可能
		char[] letters = lettersArray[chars[idx] - '2'];
		for (char letter : letters) {
			string[idx] = letter;
			dfs(idx+1, chars, string, list);;
		}
	}
}
