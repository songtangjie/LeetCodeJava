package 排序;

public class SelectionSort {
	/* 
	 * 选择排序
	 * 时间复杂度:O(n^2)，空间复杂度:O(1)
	 */	
	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
	}
}
