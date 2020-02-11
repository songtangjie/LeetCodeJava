package 排序;

public class InsertionSort {
	/* 
	 * 插入排序
	 * 时间复杂度:O(n^2)，空间复杂度:O(1)
	 */	
	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int position = i;
			while (position > 0 && arr[position-1] > value) {
				arr[position] = arr[position-1];
				position--;
			}
			arr[position] = value;
		}
	}
}
