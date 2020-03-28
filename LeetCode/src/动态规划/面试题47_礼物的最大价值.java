package 动态规划;

public class 面试题47_礼物的最大价值 {
	/* 
	 * dp[i][j] = max(dp[i-1][j],dp[i][j-1]) + 当前值
	 * 时间复杂度:O(n)，空间复杂度:O(n^2)
	 */	
    public int maxValue(int[][] grid) {
    	int rows = grid.length;
    	int cols= grid[0].length;
    	int[][] dp = new int[rows][cols];
    	dp[0][0] = grid[0][0];
    	//初始化第一列
    	for (int col = 1; col < cols; col++) {
			dp[0][col] = grid[0][col] + dp[0][col-1];
		}
    	//初始化第一行
    	for (int row = 1; row < rows; row++) {
			dp[row][0] = grid[row][0] + dp[row-1][0];
		}
    	//计算其他
    	for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]) + grid[row][col];
			}
		}
    	//返回最后一个位置元素
    	return dp[rows-1][cols-1];
    }
}
