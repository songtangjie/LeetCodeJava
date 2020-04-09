package 高频题;

public class 面试题_62_圆圈中最后剩下的数字 {
	/* 
	 * f(n, m) = (f(n – 1, m) + m) % n
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int lastRemaining(int n, int m) {
    	int res = 0;
    	for (int i = 2; i <= n; i++) {
			res = (res + m) % i;// i是数据规模，代表有多少个数字（有多少个人）
		}
    	return res;
    }
    
    //递归
    public int lastRemaining1(int n, int m) {
    	return (n == 1) ? 0 : (lastRemaining1(n - 1, m) + m) % n;
    }
}
