package 数组_排序;

public class _88_合并两个有序数组 {
	/* 三指针查找
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1 = m-1, i2 = n-1, cur = nums1.length-1;
		while (i2 >= 0) {
			if (i1 >= 0 && nums1[i1] > nums2[i2]) {//比较数字大的加入到第一个数组里
				nums1[cur--] = nums1[i1--];
			} else { // i1 < 0 || nums2[i2] >= nums1[i1]
				nums1[cur--] = nums2[i2--];
			}
		}
	}
}
