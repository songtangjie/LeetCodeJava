package 字符串;

public class 面试题_01_09_字符串轮转 {
    /* 
	 * 主字符串拼接一遍
	 * 时间复杂度:O(1)，空间复杂度:O(1)
	 */	
    public boolean isFlipedString(String s1, String s2) {
    	if (s1 == null || s2 == null) return false;
    	if (s1.length() != s2.length()) return false;
    	return (s1+s2).contains(s2);
    }
}
