package 栈_队列;

import java.util.Deque;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {
	/* 
	 * 双端队列方式
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (nums == null || nums.length == 0 || k < 1) return new int[0];
    	if (k == 1) return nums;
    	
    	//最多有n-k+1个元素
    	int[] maxes = new int[nums.length - k + 1];
    	//创建双端队列
    	Deque<Integer> deque = new LinkedList<Integer>();
    	for (int ri = 0; ri < nums.length; ri++) {
    		//构造队列是递减的顺序
    		while (!deque.isEmpty() && nums[ri] >= nums[deque.peekLast()]) {
    			deque.removeLast();
			}
    		
    		//添加到队尾
    		deque.addLast(ri);
    		
    		//检查窗口是否合法
    		int li = ri - k + 1;
    		if (li < 0) continue;
    		
    		//检查对头合法性
    		if (deque.peekFirst() < li) {
    			//不合法，索引不在窗口内
    			deque.removeFirst();
    		}
    		
    		//赋值
    		maxes[li] = nums[deque.peekFirst()];
		}
    	
    	return maxes;
    }
    
    /* 
	 * 暴力轮询
	 * 时间复杂度:O(n*k)，空间复杂度:O(n)
	 */	
    public int[] maxSlidingWindow2(int[] nums, int k) {
    	if (nums == null || nums.length == 0 || k < 1) return new int[0];
    	if (k == 1) return nums;
    	
    	//最多有n-k+1个元素
    	int[] maxes = new int[nums.length - k + 1];
    	
    	//赋值第一个区间最大值索引
    	int maxIndex = 0;
    	for (int i = 1; i < k; i++) {
			if (nums[i] > nums[maxIndex]) maxIndex = i;
		}
    	
    	for (int li = 0; li < maxes.length; li++) {
			int ri = li + k - 1;//区间最右索引
			if (maxIndex < li) {//索引不合法,重新赋值求出区间最大值
				maxIndex = li;
				for (int i = li+1; i <= ri; i++) {
					if (nums[i] > nums[maxIndex]) maxIndex = i;
				}
			} else if (nums[ri] >= nums[maxIndex]) {//索引合法，新进来的值比较大
				maxIndex = ri;
			}
			maxes[li] = nums[maxIndex];
		}
    	
    	return maxes;
    }
}
