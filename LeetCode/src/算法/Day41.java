package 算法;

public class Day41 {
	/* 
	 * 双指针法
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int[] twoSum(int[] nums, int target) {
    	int[] res = new int[2];
        if (nums == null) {
        	return res;
		}
        
        int left = 0,right = nums.length-1;
        while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				res[0] = nums[left];
				res[1] = nums[right];
				return res;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
        
        return res;
    }
}
