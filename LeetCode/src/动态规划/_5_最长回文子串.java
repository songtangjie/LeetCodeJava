package 动态规划;

public class _5_最长回文子串 {
	
	//构造cs数组
	private char[] preprocess(char[] old) {
		char[] cs = new char[(old.length << 1) + 3];
		//初始化字符
		cs[0] = '^';
		cs[1] = '#';
		cs[cs.length-1] = '$';
		for (int i = 0; i < old.length; i++) {
			int index = i+1 << 1;
			cs[index] = old[i];
			cs[index+1] = '#';
		}
		return cs;
	}
	
	/* 
	 * 马拉车算法，构造cs数组和m数组
	 * 时间复杂度:O(n)，空间复杂度:O(n^2)
	 */	
    public String longestPalindromeManacher(String s) {
    	if (s == null) return null;
    	char[] old = s.toCharArray();
    	if (old.length <= 1) return s;
    	
    	//构造cs数组
    	char[] cs = preprocess(old);
    	//构造m数组
    	int[] m = new int[cs.length];
    	int c = 1, r = 1, laseIndex = cs.length - 2;
    	int maxLen = 0, index = 0;
    	for (int i = 2; i < laseIndex; i++) {
			if (r > i) {
				int li = (c << 1) - i;
				//半径范围如果超过r，则m[i]至少为m[li]，否则为半径r-i
				m[i] = (i + m[li] <= r) ? m[li] : r-i;
			}
			
			//中心扩展半径
			while (cs[i - m[i] - 1] == cs[i + m[i] + 1]) {
    			m[i]++;
    		}
			//更新c、r的值
			if (i + m[i] > r) {
				c = i;
				r = i + m[i];
			}
			//找到更大值
			if (m[i] > maxLen) {
    			maxLen = m[i];
    			index = i;
    		}
			
		}
    	
    	int begin = (index - maxLen) >> 1;
    	return new String(old, begin, maxLen);
    }
	
	/* 
	 * 扩展中心法2，把字符串分为相同字符的几个子串，遍历跳过成为新的中心点扩展
	 * 时间复杂度:O(<n^2)，空间复杂度:O(n^2)
	 */	
    public String longestPalindrome2(String s) {
    	if (s == null) return null;
    	char[] cs = s.toCharArray();
    	if (cs.length <= 1) return s;
    	int maxLen = 1;//最长回文串长度至少是1
    	int begin = 0;//开始索引
    	int i = 0;
    	while (i < cs.length) {
    		int l = i - 1;
    		//找到右边第一个不等于cs[i]的位置
    		int r = i;
    		while (++r < cs.length && cs[r] == cs[i]);
    		//更新i的值
    		i = r;
    		//扩展中心
    		while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
    			l--;
    			r++;
    		}
    		
    		// 扩展结束后，cs[l + 1, r)就是刚才找到的最大回文子串
    		// ++l后，l就是刚才找到的最大回文子串的开始索引
    		int len = r - ++l;
    		if (len > maxLen) {
    			maxLen = len;
    			begin = l;
    		}
    	}
    	
    	return new String(cs, begin, maxLen);
    }
	
	
	/* 
	 * 确定中心点，分为字符n和字符之间n+1种，双指针查找
	 * 时间复杂度:O(n^2)，空间复杂度:O(1)
	 */	
    public String longestPalindrome(String s) {
    	int n = s.length();
    	if (s == null || n < 1) return "";
    	int start = 0, end = 0;
    	for (int i = 0; i < n; i++) {
    		//中心点在字符上
			int len1 = expandAroundCenter(s, i, i);
			//中心点在字符之间
			int len2 = expandAroundCenter(s, i, i+1);
			//更新最大值
			int maxLen = Math.max(len1, len2);
			if (maxLen > end - start) {
				start = i - ((maxLen-1) >>1);
				end = i + (maxLen >> 1);
			}
		}
    	
    	return s.substring(start, end+1);
    }
    
    //双指针轮询当前中心点回文长度
    private int expandAroundCenter(String s, int left,int right) {
		int L = left,R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
}
