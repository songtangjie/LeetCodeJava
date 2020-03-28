package 动态规划;

public class _121_买卖股票的最佳时机 {
	/* 
	 * 记录最小值和最大价值
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
    	
    	int minPrice = prices[0];
    	int max = 0;
    	for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else {
				max = Math.max(max, prices[i] - minPrice);
			}
		}
    	return max;
    }
}
