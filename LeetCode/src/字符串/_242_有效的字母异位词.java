package 字符串;

public class _242_有效的字母异位词 {
    /* 
	 * 字符串转字符数组，数组26长度，遍历第一个数组元素++，第二个数组元素--，有元素<0则数量不同
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public boolean isAnagram(String s, String t) {
    	if (s == null || t == null) return false;
    	char[] schars = s.toCharArray();
    	char[] tchars = t.toCharArray();
    	if (schars.length != tchars.length) return false;
    	
    	int[] counts = new int[26];
    	for (int i = 0; i < schars.length; i++) {
			counts[schars[i] - 'a']++;
		}
    	
    	for (int i = 0; i < tchars.length; i++) {
			if (--counts[tchars[i] - 'a'] < 0) return false;
		}
    	return true;
    }
}
