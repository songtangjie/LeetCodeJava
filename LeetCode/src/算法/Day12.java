package 算法;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day12 {
	
	/* 快慢指针查找链表的环
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
	public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        
        while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
        
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
			pre1 = nums[pre1];
			pre2 = nums[pre2];
		}
        
        return pre1;
    }
	
	/* 用哈希表的唯一性来判断
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */
	public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
        return -1;
    }
	
	/* 先排序再查找前后数字
	 * 时间复杂度:O(n)，空间复杂度:O(1)或O(n)
	 */
	public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i-1]) {
				return nums[i];
			}
		}
        return -1;
    }
}
