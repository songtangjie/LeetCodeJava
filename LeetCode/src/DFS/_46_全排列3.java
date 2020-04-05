package DFS;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列3 {
	
	/* 
	 * DFS算法【局部变量传参】
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public List<List<Integer>> permute(int[] nums) {
    	if (nums == null) return null;
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if (nums.length == 0) return list;
    	dfs(0, nums, list);;
    	return list;
    }
    
    //递归
    private void dfs(int idx, int[] nums, List<List<Integer>> list) {
		if (idx == nums.length) {
			List<Integer> result = new ArrayList<Integer>();
			for (int value : nums) {
				result.add(value);
			}
			list.add(result);
			return;
		}
		
		for (int i = idx; i < nums.length; i++) {
			swap(nums, idx, i);
			
			dfs(idx+1, nums, list);
			
			//还原现场
			swap(nums, idx, i);
		}
	}
    
    //交换值
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
