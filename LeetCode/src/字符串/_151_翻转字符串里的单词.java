package 字符串;

public class _151_翻转字符串里的单词 {
    /* 
	 * 先去空格，再翻转整个串，最后逐个单词翻转,注意最后一个单词
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public String reverseWords(String s) {
    	if (s == null) return "";
    	char[] chars = s.toCharArray();
    	
    	//记录串的有效长度
    	int len = 0;
    	//用于标识
    	int cur = 0;
    	//用于判断前一个字符是否是空格
    	boolean isSpace = true;
    	//消除空格
    	for (int i = 0; i < chars.length; i++) {
			if (chars[i] != ' ') {//非空格
				chars[cur++] = chars[i];
				isSpace = false;
			} else if (!isSpace) {//当前是空格，前一个是非空格
				chars[cur++] = ' ';
				isSpace = true;
			}
		}
    	//如果最后还有一个空格则先去掉
    	len = isSpace ? cur-1 : cur;
    	if (len <= 0) return ""; 
    	
    	//翻转整个串
    	reverse(chars, 0, len);
    	//前一个空格索引
    	int preSpaceIndex = -1;
    	//逐个翻转单词
    	for (int i = 0; i < len; i++) {
			if (chars[i] != ' ') continue;
			reverse(chars, preSpaceIndex+1, i);
			preSpaceIndex = i;
		}
    	
    	//翻转最后一个单词
    	reverse(chars, preSpaceIndex+1, len);
    	
    	return new String(chars, 0 , len);
    }
    
    //字符数组翻转[li,ri)
    private void reverse(char[] chars, int li, int ri) {
		ri--;
		while (li < ri) {
			char tmp = chars[li];
			chars[li] = chars[ri];
			chars[ri] = tmp;
			li++;
			ri--;
		}
	}
}
