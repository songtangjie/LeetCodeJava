package 排序;

public class QuickSort {
	/* 
	 * 快速排序
	 * 时间复杂度:O(nlogn)，空间复杂度:O(n)
	 */	
	public void quickSort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}
	
	//具体实现
	private void sort(int[] arr, int begin, int end) {
		//就1个元素时
		if (begin >= end) {
			return;
		}
		
		//轴点位置
		int pivot = pivotIndex(arr, begin, end);
		//前面部分
		sort(arr, begin, pivot-1);
		//后面部分
		sort(arr, pivot+1, end);
	}
	
	//构造轴点
	private int pivotIndex(int[] arr, int begin, int end) {
		//保存轴点元素
		int pivot = arr[begin];
		
		while (begin < end) {
			//从后查找比轴点小的元素
			while (begin < end && pivot <= arr[end]) {
				end--;
			}
			arr[begin] = arr[end];
			
			//从前查找比轴点大的元素
			while (begin < end && pivot >= arr[begin]) {
				begin++;
			}
			arr[end] = arr[begin];
		}
		//替换轴点元素位置
		arr[begin] = pivot;
		
		return begin;
	}
}
