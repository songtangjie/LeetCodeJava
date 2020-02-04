package 排序;

public class BubbleSort {
	/* 
	 * 冒泡排序
	 * 时间复杂度:O(n^2)，空间复杂度:O(1)
	 */	
	public void bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}
