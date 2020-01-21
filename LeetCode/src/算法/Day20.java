package 算法;

public class Day20 {
	/* 
	 * 动态规划
	 */	
	public boolean isMatch2(String s, String p) {
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[s.length()][p.length()] = true;
		
		for (int i = s.length(); i >= 0; i--) {
			for (int j = p.length()-1; j >= 0; j--) {
				//第一个字符是否匹配:1、第一个字符一样 2、子串第一个字符是'.'
				boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
				//如果子串长度超过2且第二个字符是'*'
				if (j + 1 < p.length() && p.charAt(j+1) == '*') {
					//1、子串去掉前2个字符后继续匹配  2、主串去掉第一个字符继续匹配
					dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
				} else {//否则从第二个字符开始匹配
					dp[i][j] = firstMatch && dp[i+1][j+1];
				}
			}
		}
		
		return dp[0][0];
	}
	
	/* 
	 * 回溯法递归
	 */	
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		
		//第一个字符是否匹配:1、第一个字符一样 2、子串第一个字符是'.'
		boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		
		//如果子串长度超过2且第二个字符是'*'
		if (p.length() >= 2 && p.charAt(1) == '*') {
			//1、子串去掉前2个字符后继续匹配  2、主串去掉第一个字符继续匹配
			return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
		} else {//否则从第二个字符开始匹配
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}
	}
}
