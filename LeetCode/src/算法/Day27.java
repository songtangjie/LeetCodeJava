package 算法;

public class Day27 {
	/* 
	 * 动态规划
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxNum = nums[0];
        for (int i = 1; i < n; i++) {
			if (nums[i-1] > 0) {
				nums[i] += nums[i-1];
			}
			maxNum = Math.max(nums[i], maxNum);
		}
        return maxNum;
    }
    
	/* 
	 * 贪心
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int maxNum = nums[0], currSum = nums[0];
        
        for (int i = 1; i < n; i++) {
			currSum = Math.max(nums[i], currSum + nums[i]);
			maxNum = Math.max(currSum, maxNum);
		}
        return maxNum;
    }
}
