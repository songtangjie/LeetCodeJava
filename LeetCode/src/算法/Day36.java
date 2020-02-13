package 算法;

public class Day36 {
	/* 
	 * 二分法查找临界值
	 * 时间复杂度:O(logn)，空间复杂度:O(1)
	 */	
    public int[] searchRange(int[] nums, int target) {
    	int[] targetRange = {-1, -1};
    	if (nums.length > 0) {
			int first = getFirstK(nums, nums.length, target, 0, nums.length - 1);
			int last = getLastK(nums, nums.length, target, 0, nums.length - 1);
			
			if (first > -1 && last > -1) {
				targetRange[0] = first;
				targetRange[1] = last;
			}
		}
    	return targetRange;
    }
    
    //取最小的索引
    private int getFirstK(int[] nums, int length, int target, int start, int end) {
		if (start > end) {
			return - 1;
		}
		
		int midIndex = (start + end) >> 1;
		if (nums[midIndex] == target) {
			if (midIndex == 0 || (midIndex > 0 && nums[midIndex-1] != target)) {//只有一个元素或前一个值不是目标值
				return midIndex;
			} else {//前一个值也是目标值
				end = midIndex - 1;
			}
		} else if (nums[midIndex] > target) {
			end = midIndex - 1;
		} else {
			start = midIndex + 1;
		}
		return getFirstK(nums, length, target, start, end);
	}
    
  //取最大的索引
    private int getLastK(int[] nums, int length, int target, int start, int end) {
    	if (start > end) {
			return - 1;
		}
		
		int midIndex = (start + end) >> 1;
		if (nums[midIndex] == target) {
			if (midIndex == length-1 || (midIndex < length-1 && nums[midIndex+1] != target)) {//只有一个元素或后一个值不是目标值
				return midIndex;
			} else {//后一个值也是目标值
				start = midIndex + 1;
			}
		} else if (nums[midIndex] > target) {
			end = midIndex - 1;
		} else {
			start = midIndex + 1;
		}
		return getLastK(nums, length, target, start, end);
	}
}
