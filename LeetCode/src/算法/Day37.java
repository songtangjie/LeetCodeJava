package 算法;

public class Day37 {
	/* 
	 * 二分法查找临界值
	 * 时间复杂度:O(logn)，空间复杂度:O(1)
	 */	
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
			return -1;
		}
        int left = 0, right = nums.length-1;
        while (left <= right) {
			int mid = (left + right) >> 1;
        	if (nums[mid] != mid) {
				if (mid == 0 || nums[mid-1] == mid-1) {//前面那个数是正确的,当前数不对则拿到值
					return mid;
				} else {//前区间里去找
					right = mid - 1;
				}
			} else {//后区间里去找
				left = mid + 1;
			}
		}
        
        if (left == nums.length) {
			return nums.length;
		}
        
        return - 1;
    }
}
