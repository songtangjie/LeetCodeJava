package DFS;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列2 {
	private List<List<Integer>> list;
	private int[] nums;
	//保存每层选择的数字
	private List<Integer> result;
	
	/* 
	 * DFS算法【不使用数组保存是否数字使用过】
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public List<List<Integer>> permute(int[] nums) {
    	if (nums == null) return null;
    	list = new ArrayList<List<Integer>>();
    	if (nums.length == 0) return list;
    	this.nums = nums;
    	result = new ArrayList<Integer>();
    	dfs(0);
    	return list;
    }
    
    //递归
    private void dfs(int idx) {
		if (idx == nums.length) {
			list.add(new ArrayList<>(result));
			return;
		}
		
		for (int num : nums) {
			if (result.contains(num)) continue;
			result.add(num);
			
			dfs(idx+1);
			
			//还原现场
			result.remove(result.size()-1);
		}
	}
}
