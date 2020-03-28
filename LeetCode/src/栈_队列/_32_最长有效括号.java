package 栈_队列;

public class _32_最长有效括号 {
	/* 
	 * 左右括号计数器，从左到右遍历，从右到左遍历
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int longestValidParentheses(String s) {
    	int left = 0,right = 0,max = 0;
    	int n = s.length();
    	//从左到右遍历，但无法匹配(()
    	for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			
			if (left == right) {//相等则计算长度
				max = Math.max(max, 2*left);
			} else if (right > left) {//如果right>left,则清0
				left = right = 0;
			}
		}
    	//清零
    	left = right = 0;
    	//从右到左遍历，但无法匹配())
    	for (int i = n-1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			
			if (left == right) {//相等则计算长度
				max = Math.max(max, 2*left);
			} else if (left > right) {//清0
				left = right = 0;
			}
		}
    	return max;
    }
}
