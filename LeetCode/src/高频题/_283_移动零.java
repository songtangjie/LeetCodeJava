package 高频题;

public class _283_移动零 {
	/* 
	 * 增加一个值，遇到非0交换
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public void moveZeroes(int[] nums) {
    	if (nums == null) return;
    	for (int i = 0,cur = 0; i < nums.length; i++) {
			if (nums[i] == 0) continue;
			if (cur != i) {
				nums[cur] = nums[i];
				nums[i] = 0;
			}
			cur++;
		}
    }
}
