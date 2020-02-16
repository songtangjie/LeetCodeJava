package 算法;

public class Day43 {
	/* 
	 * 双指针遍历法
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        //去掉前后的空格
        s = s.trim();
        int i = s.length()-1,j = s.length();
        while (i > 0) {
			if (s.charAt(i) == ' ') {//遍历到一组词
				res.append(s.substring(i+1,j));
				res.append(' ');
				//忽略中间的空格
				while (s.charAt(i) == ' ') {
					i--;
				}
				j = i + 1;
			}
			i--;
		}
        return res.append(s.substring(0,j)).toString();
    }
}
