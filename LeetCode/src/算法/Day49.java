package 算法;

public class Day49 {
	/* 
	 * 双端数组动态规划，left数组保存从左到右最大值，right反之，结合2个数组输出最值数组
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int n = nums.length;
    	if (n *k == 0) return new int[0];
    	if (k == 1) return nums;
    	
    	int[] left = new int[n];
    	left[0] = nums[0];
    	int[] right = new int[n];
    	right[n-1] = nums[n-1];
    	
    	for (int i = 1; i < n; i++) {
    		//从左到后构建left数组
			if (i % k == 0) {//k个一组边界值
				left[i] = nums[i];
			} else {
				//取当前值和前面比较大的
				left[i] = Math.max(left[i-1], nums[i]);
			}
			
			//从右到左构建right数组
			int j = n - i - 1;
			if ((j+1) % k == 0) {//k个一组边界值
				right[j] = nums[j];
			} else {
				//取当前值和后面比较大的
				right[j] = Math.max(right[j+1], nums[j]);
			}
		}
    	
    	int[] out = new int[n - k + 1];
    	for (int i = 0; i < n - k + 1; i++) {
			out[i] = Math.max(right[i], left[i + k - 1]);
		}
    	
    	return out;
    }
}
