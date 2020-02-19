package 数组_排序;

public class _75_颜色分类 {
	/* 三指针查找
	 * 时间复杂度:O(1)，空间复杂度:O(1)
	 */
	public void sortColors(int[] nums) {
		int r = 0, g = 0, p = nums.length-1;
		while (r <= p) {
			int v = nums[r];
			if (v == 0) {
				//交换值并往后移动红色和绿色指针
				swap(nums, g++, r++);
			} else if (v == 1) {//只移动红色指针
				r++;
			} else { // v=2 ，移动蓝色指针，红色指针的值需要重新判断
				swap(nums, p--, r);
			}
		}
	}
	
	//交换数组的值
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
