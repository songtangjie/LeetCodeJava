package 动态规划;

public class _72_编辑距离 {
	/* 
	 * 动态规划创建二维数组记录值【代表从串1第i个位置字符到串2第j个位置字符】
	 * 时间复杂度:O(m*n)，空间复杂度:O(m*n)
	 */	
    public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null) return 0;
    	char[] cs1 = word1.toCharArray();
    	char[] cs2 = word2.toCharArray();
    	
    	int[][] dp = new int[cs1.length+1][cs2.length+1];
    	//初始化值
    	dp[0][0] = 0;
    	for (int i = 1; i <= cs1.length; i++) {
			dp[i][0] = i;
		}
    	for (int j = 1; j <= cs2.length; j++) {
			dp[0][j] = j;
		}
    	
    	for (int i = 1; i <= cs1.length; i++) {
			for (int j = 1; j <= cs2.length; j++) {
				int top = dp[i][j - 1]+1;
				int left = dp[i - 1][j]+1;
				int leftTop = dp[i-1][j-1];
				if (cs1[i-1] != cs2[j-1]) {
					leftTop++;
				}
				dp[i][j] = Math.min(top, Math.min(left, leftTop));
			}
		}
    	
    	return dp[cs1.length][cs2.length];
    }
}
