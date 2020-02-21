package 数组_排序;

public class _977_有序数组的平方 {
	/* 
	 * 找到负数临界值，双指针遍历
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int right = 0;//右指针
        while (right < n && A[right] < 0) {
			right++;
		}
        int[] ans = new int[n];
        int left = right-1;//左指针
        int cur = 0;
        while (left >= 0 && right < n) {
			if (A[left] * A[left] < A[right] * A[right]) {//左部分值小于右部分
				ans[cur++] = A[left] * A[left];
				left--;
			} else {
				ans[cur++] = A[right] * A[right];
				right++;
			}
		}
        
        //左部分有剩余元素
        while (left >= 0) {
        	ans[cur++] = A[left] * A[left];
			left--;
		}
        
      //右部分有剩余元素
        while (right < n) {
        	ans[cur++] = A[right] * A[right];
        	right++;
		}
        
        return ans;
    }
}
