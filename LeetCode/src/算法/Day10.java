package 算法;

import java.util.HashMap;
import java.util.Map;

public class Day10 {
	
	// 动态规划矩阵法【时间O(n^2),空间O(n^2)】
    public void palindrome3(String s) {
    	Map<String, String> map = new HashMap<>();
    	
    	if (s.length() < 2) {// 长度小于2无需判断
    		System.out.println(s);
        }
    	
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	
    	for (int r = 0; r < s.length(); r++) {
    		for (int l = 0; l <= r; l++) {
    			// 判断条件：回文最外面字符相等且内层回文区间不足
    			if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])) {
    				dp[l][r] = true;
    				String subStr = s.substring(l, r+1);
    				map.put(subStr, subStr);
    			}
    		}
    	}
    	
    	for(String str : map.values()) {
    		System.out.println(str);
    	}

    }
	
	// 中心扩散法【时间O(n^2),空间O(1)】
    public void palindrome2(String s) {
    	
    	Map<String, String> map = new HashMap<>();
    	
    	if (s.length() < 2) {// 长度小于2无需判断
    		System.out.println(s);
        }
    	
    	for (int i = 0; i < s.length(); i++) {
    		String centerOddStr = subStr(s, i , i);//奇数
    		String centerEvenStr = subStr(s, i , i+1);//偶数
    		
    		if (centerOddStr.length() > 0) map.put(centerOddStr, centerOddStr);
    		if (centerEvenStr.length() > 0) map.put(centerEvenStr, centerEvenStr);
    	}
    	
    	for(String str : map.values()) {
    		System.out.println(str);
    	}

    }
    
    private String subStr(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
    	
    	int i = left;
    	int j = right;
    			
    	while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
    		i--;
    		j++;
    	}
    	
    	return s.substring(i+1, j);
    }
	
	// 暴力法【时间O(n^3),空间O(1)】
    public void palindrome1(String s) {
    	
    	Map<String, String> map = new HashMap<>();
    	
    	if (s.length() < 2) {// 长度小于2无需判断
    		System.out.println(s);
        }
    	
    	for (int i = 0; i < s.length(); i++) {
    		if (i == s.length()-1) map.put(s.substring(i, i+1), s.substring(i, i+1));
    		
    		for (int j = i+1; j < s.length(); j++) {
    			// 构造子串
        		String subStr = s.substring(i, j);
        		boolean isPalindrome = true;
        		// 轮询查找是否是回文
        		for (int k = 0; k < (subStr.length()>>1); k++) {
            		if (subStr.charAt(k) != subStr.charAt(subStr.length() - k - 1)) {
            			isPalindrome = false;
            			break;
            		}
            	}
        		
        		if (isPalindrome) {
        			map.put(subStr, subStr);
        		}
        	}
    	}
    	
    	for (String str : map.values()) {
    		System.out.println(str);
    	}

    }
}
