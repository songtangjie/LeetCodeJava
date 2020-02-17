package 算法;

public class Day44 {
	/* 
	 * 动态规划
	 * F(n,s)=F(n−1,s−1)+F(n−1,s−2)+F(n−1,s−3)+F(n−1,s−4)+F(n−1,s−5)+F(n−1,s−6)
	 * 时间复杂度:O(n^2)，空间复杂度:O(n^2)
	 */	
    public double[] twoSum(int n) {
        int[][] dp = new int[n+1][6*n+1];
        //边界条件
        for (int s = 1; s <= 6; s++) {
			dp[1][s] = 1;
		}
        
        for (int i = 2; i <= n; i++) {
			for (int s = i; s <= 6*i; s++) {
				//求dp[i][s]
				for (int d = 1; d <= 6; d++) {
					if (s-d < i-1) {//为0
						break;
					}
					dp[i][s] += dp[i-1][s-d];
				}
			}
		}
        
        double total = Math.pow((double)6, (double)n);
        double[] ans = new double[5*n+1];
        for (int i = n; i <= 6*n; i++) {
			ans[i-n] = ((double)dp[n][i]) / total;
		}
        return ans;
    }
}
