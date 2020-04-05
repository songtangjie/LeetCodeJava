package DFS;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {
	private List<List<Integer>> list;
	private int[] nums;
	//保存每层选择的数字
	private int[] result;
	//标记每层的数字是否使用过
	private boolean[] used;
	
	/* 
	 * DFS算法【数组保存是否数字使用过】
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public List<List<Integer>> permute(int[] nums) {
    	if (nums == null) return null;
    	list = new ArrayList<List<Integer>>();
    	if (nums.length == 0) return list;
    	this.nums = nums;
    	result = new int[nums.length];
    	used = new boolean[nums.length];
    	dfs(0);
    	return list;
    }
    
    //递归
    private void dfs(int idx) {
		if (idx == nums.length) {
			List<Integer> resultList = new ArrayList<Integer>();
			for (int value : result) {
				resultList.add(value);
			}
			list.add(resultList);
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			result[idx] = nums[i];
			used[i] = true;
			
			dfs(idx+1);
			
			//还原现场
			used[i] = false;
		}
	}
}
