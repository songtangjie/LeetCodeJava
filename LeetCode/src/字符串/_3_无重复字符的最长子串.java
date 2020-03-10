package 字符串;

import java.util.HashMap;
import java.util.Map;

public class _3_无重复字符的最长子串 {
	/* 
	 * 长度128的数组保存每个字符上次出现的索引
	 * 时间复杂度:O(n)，空间复杂度:O(128)
	 */	
    public int lengthOfLongestSubstring(String s) {
    	if (s == null) return 0;
    	char[] chars = s.toCharArray();
    	
    	if (chars.length == 0) return 0;
    	
    	//保存每个字符上次出现的索引
    	int[] preIndex = new int[128];
    	//初始化
    	for (int i = 0; i < preIndex.length; i++) {
			preIndex[i] = -1;
		}
    	//第一个元素
    	preIndex[chars[0]] = 0;
    	
    	//记录当前字符之前一个字符的最长不重复子串的最左索引值
    	int li = 0;
    	//最长值
    	int max = 1;
    	for (int i = 1; i < chars.length; i++) {
    		int pi = preIndex[chars[i]];
			if (li <= pi) {//当前字符之前出现过，则li的值为pi+1
				li = pi + 1;
			}
			
			preIndex[chars[i]] = i;
			max = Math.max(max, i - li + 1);
		}
    	return max;
    }
    
    /* 
	 * 哈希表保存每个字符上次出现的索引
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int lengthOfLongestSubstring2(String s) {
    	if (s == null) return 0;
    	char[] chars = s.toCharArray();
    	
    	if (chars.length == 0) return 0;
    	
    	//保存每个字符上次出现的索引
    	Map<Character, Integer> preIndex = new HashMap<Character, Integer>();
    	//第一个元素
    	preIndex.put(chars[0], 0);
    	
    	//记录当前字符之前一个字符的最长不重复子串的最左索引值
    	int li = 0;
    	//最长值
    	int max = 1;
    	for (int i = 1; i < chars.length; i++) {
    		Integer pi = preIndex.get(chars[i]);
			if (pi != null && li <= pi) {//当前字符之前出现过，则li的值为pi+1
				li = pi + 1;
			}
			
			preIndex.put(chars[i], i);
			max = Math.max(max, i - li + 1);
		}
    	return max;
    }
}
