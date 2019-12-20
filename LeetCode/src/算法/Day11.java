package 算法;

import java.util.Arrays;

public class Day11
{
	/* 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。【摆动排序】
	 * 先排序再穿插
     * O(nlogn)+O(n)=O(nlogn)
	 */
    public void wiggleSort(int[] nums)
    {
    	// 排序
        Arrays.sort(nums);
        
        int len = nums.length, 
        		i = 0;
        int[] small = new int[len % 2 == 0 ? len / 2 : (len / 2 + 1)],
        		big = new int[len / 2];
        // 复制数据到新数组
        System.arraycopy(nums, 0, small, 0, small.length);
        System.arraycopy(nums, small.length, big, 0, len / 2);
        
        // 从大到小倒序穿插数据
        for (; i < len / 2; i++) {
        	nums[2 * i] = small[small.length - 1 - i];
        	nums[2 * i + 1] = big[len / 2 - 1 - i];
        }
        // 补位中间数
        if (len % 2 != 0) {
        	nums[2 * i] = small[small.length - 1 - i];
        }
        
    	for(int num : nums) {
    		System.out.println(num);
    	}
    }
    
	/* 
	 * 先排序再穿插,排序用快速选择，然后将数组分为3部分：小+中+大
     * O(n)+O(n)=O(n)
	 */
    public void wiggleSort2(int[] nums)
    {
    	if (nums.length < 2) return;
    	
    	int len = nums.length;
    	quickSelect(nums, 0, len , len / 2);
    	int mid = nums[len / 2];
    	
    	// 三路并发排序
    	int i = 0,j = 0, k = len-1;
    	while (j < k) {
    		if (nums[j] > mid) {
    			swap(nums,j, k);
    			--k;
    		} else if (nums[j] < mid) {
    			swap(nums,j, i);
    			++i;
    			++j;
    		} else {
    			++j;
    		}
    	}
    	
        int[] small = new int[len % 2 == 0 ? len / 2 : (len / 2 + 1)],
        		big = new int[len / 2];
        // 复制数据到新数组
        System.arraycopy(nums, 0, small, 0, small.length);
        System.arraycopy(nums, small.length, big, 0, len / 2);
        
        for (int i1 = 0 ; i1 < small.length; i1++) {
        	nums[2 * i1] = small[small.length - 1 - i1];
        }
        for (int i1 = 0; i1 < big.length; i1++) {
        	nums[2 * i1 + 1] = big[big.length - 1 - i1];
        }
        
    	for(int num : nums) {
    		System.out.println(num);
    	}
    }
    
    // 快速选择，将数组按数字大小排列:O(n)
    void quickSelect(int[] nums, int begin, int end, int n) 
    {
    	int t = nums[end - 1];
    	int i = begin, j = begin;
    	while (j < end) {
    		if (nums[j] <= t) {
    			swap(nums,i++, j++);
    		} else {
    			++j;
    		}
    	}
    	if (i - 1 > n) {
    		quickSelect(nums, begin, i-1 , n);
    	} else if (i <= n) {
    		quickSelect(nums, i, end , n);
    	}
    }
    
    // 交换数组2个数字
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
