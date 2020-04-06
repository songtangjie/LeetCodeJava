package 高频题;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
	/* 
	 * 哈希表存储遍历过的值
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] twoSum(int[] nums, int target) {
    	if (nums == null) return null;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			Integer idx = map.get(target - nums[i]);
			//找到值匹配
			if (idx != null) return new int[] {idx, i}; 
			//未找到值
			map.put(nums[i], i);
		}
    	return null;
    }
}
