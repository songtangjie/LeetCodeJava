package 算法;

public class Day15 {
	/* 二分查找，双指针
	 * 时间复杂度:O(logn)，空间复杂度:O(1)
	 * 本解法适用于有重复数字
	 */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
			return nums[0];
		}
        
        int pre = 0;
        int last = nums.length-1;
        int mid = pre;
        
        while (nums[pre] >= nums[last]) {
			if (last - pre == 1) {
				mid = last;
				break;
			}
			
			mid = (last + pre) / 2;
			
			//如果出现重复数字，则顺序遍历查找
			if (nums[pre] == nums[last] && nums[pre] == nums[mid]) {
				int result = nums[pre];
				for (int i = pre+1; i <= last; i++) {
					if (result > nums[i]) {
						result = nums[i];
					}
				}
				return result;
			}
			
			if (nums[mid] >= nums[pre]) {
				pre = mid;
			} else if (nums[mid] <= nums[last]) {
				last = mid;
			}
		}
        return nums[mid];
    }
	
	/* 二分查找，双指针
	 * 时间复杂度:O(logn)，空间复杂度:O(1)
	 * 本解法适用于没有重复数字
	 */
    public int findMin1(int[] nums) {
        if (nums.length == 1) {
			return nums[0];
		}
        
        int pre = 0;
        int last = nums.length-1;
        int mid = pre;
        
        while (nums[pre] >= nums[last]) {
			if (last - pre == 1) {
				mid = last;
				break;
			}
			
			mid = (last + pre) / 2;
			
			if (nums[mid] >= nums[pre]) {
				pre = mid;
			} else if (nums[mid] <= nums[last]) {
				last = mid;
			}
		}
        return nums[mid];
    }
}
