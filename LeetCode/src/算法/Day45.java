package 算法;

import java.util.Arrays;

public class Day45 {
	/* 
	 * 先排序，大小王为0，可以替代任何数。出现对子则肯定不是顺子。
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public boolean isStraight(int[] nums) {
    	//先排序
        Arrays.sort(nums);
        
        int diff = 0,zero = 0;
        int flag = -1;//用于判断是第一个
        for (int i = 0; i < nums.length; i++) {
        	//如果数字是0跳过
			if (nums[i] == 0) {
				zero++;
				continue;
			}
			
			//第一个数字也跳过
			if (flag == -1) {
				flag = nums[i];
				continue;
			}
			
			//如果是对子则不是顺子
			if (nums[i] == nums[i-1]) {
				return false;
			}
			
			//记录前后2个数的差距，便于插入0
			diff += nums[i] - nums[i-1] - 1;
		}
        
        return diff == 0 || (diff-zero <= 0);
    }
}
