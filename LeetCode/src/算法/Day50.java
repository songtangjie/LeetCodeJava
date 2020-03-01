package 算法;

public class Day50 {
	/* 
	 * 遍历到第i个数字，则和前i-1个数字的最小值的差值。
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int maxProfit(int[] prices) {
    	int minPrice = Integer.MAX_VALUE;
    	int maxPro = 0;
    	for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {//当前值小于最小值
				 minPrice = prices[i];
			} else if (prices[i] - minPrice > maxPro) {//差值超过之前的最大值替换
				maxPro = prices[i] - minPrice;
			}
		}
    	return maxPro;
    }
}
