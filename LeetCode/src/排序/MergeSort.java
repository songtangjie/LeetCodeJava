package 排序;

public class MergeSort {
	/* 
	 * 归并排序
	 * 时间复杂度:O(nlogn)，空间复杂度:O(n)
	 */	
	public void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length];
		divide(arr, tmp, 0, arr.length-1);
	}
	
	//分解
	private void divide(int[] arr, int[] tmp, int left, int right) {
		if (left < right) {
			int mid = (left + right) >> 1;
			divide(arr, tmp, left, mid);//左
			divide(arr, tmp, mid+1, right);//右
			//合并
			merge(arr, tmp, left, mid, right);
		}
	}
	
	//合并
	private void merge(int[] arr, int[] tmp, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		int k = 0;
		while (i <= mid && j <= right) {
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
	}
}
