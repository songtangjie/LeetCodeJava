package 算法;

public class Day34 {
	/* 
	 * 归并排序并统计
	 * 时间复杂度:O(nlogn)，空间复杂度:O(n)
	 */	
    public int reversePairs(int[] nums) {
		int[] tmp = new int[nums.length];
		return divide(nums, tmp, 0, nums.length-1);
    }
    

	//分解
	private int divide(int[] arr, int[] tmp, int left, int right) {
		if (left < right) {
			int mid = (left + right) >> 1;
			int leftCount = divide(arr, tmp, left, mid);//左
			int rightCount = divide(arr, tmp, mid+1, right);//右
			int divideCount = leftCount + rightCount;
			
			if (arr[mid] <= arr[mid+1]) {
				return divideCount;
			}
			//合并
			int mergeCount = merge(arr, tmp, left, mid, right);
			return divideCount + mergeCount;
		}
		return 0;
	}
	
	//合并
	private int merge(int[] arr, int[] tmp, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int k = 0;
		int res = 0;
		while (i <= mid && j <= right) {
			// 此时后数组元素出列，统计逆序对，快就快在这里，一次可以统计出一个区间的个数的逆序对
			if (arr[i] > arr[j]) {
				res += (mid - i + 1);
			}
			tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		
		//左边有剩余元素
		while (i <= mid) {
			tmp[k++] = arr[i++];
		}
		//右边有剩余元素
		while (j <= right) {
			tmp[k++] = arr[j++];
		}
		
		for (int l = 0; l < k; l++) {
			arr[left+l] = tmp[l];
		}
		
		return res;
	}
}
