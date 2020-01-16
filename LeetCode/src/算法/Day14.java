package 算法;

import java.util.Arrays;

public class Day14 {
	/* 从后往前，双指针查找插入
	 * 时间复杂度:O(n+m)，时间复杂度:O(1)
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m-1;//记录第一个数组索引
		int p2 = n-1;//记录第二个数组
		int p = m+n-1;//表示合并后数组索引
		
		while (p1 >= 0 && p2 >=0 ) {
			//比较数字大的加入到第一个数组里
			nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
		}
		//添加剩余的第二个数组的元素
		System.arraycopy(nums2, 0, nums1, 0, p2+1);
	}
	
	/* 合并后排序
	 * 时间复杂度:O((n+m)log(n+m))，时间复杂度:O(1)
	 */
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
}
