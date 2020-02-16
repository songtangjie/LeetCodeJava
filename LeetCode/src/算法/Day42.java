package 算法;

import java.util.Arrays;

public class Day42 {
	/* 
	 * 双指针法
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int[][] findContinuousSequence(int target) {
        int[][] res = new int[0][];
        int left = 1,right = 2;
        int middle = target/2 + 1;
        int curSum = 0;
        
        while (right <= middle && left < right) {
        	if (curSum == 0) {
				curSum = left + right;
			}
			if (curSum == target) {
				//构造一个新结果数组
				int[] a = new int[right-left+1];
				for (int i = left; i <= right; i++) {
					a[i - left] = i;
				}
				res = copy(res, a);
				
				//重新查找新数组
				curSum -= left;
				left++;
			} else if (curSum < target) {
				right++;
				curSum += right;
			} else {
				curSum -= left;
				left++;
			}
		}
        
        return res;
    }
    
    //拷贝生成新的数组
    private int[][] copy(int[][] result, int[] a) {
        int[][] newArray = Arrays.copyOf(result, result.length + 1);
        newArray[newArray.length - 1] = a;
        return newArray;
    }
}
