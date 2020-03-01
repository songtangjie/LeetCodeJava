package 算法;

public class Day51 {
	/* 
	 * 正向遍历，反向遍历，相乘结果
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] constructArr(int[] a) {
    	int left = 1;
    	int[] result = new int[a.length];
    	for (int i = 0; i < a.length; i++) {
			result[i] = left;
			left *= a[i];
		}
    	
    	int right = 1;
    	for (int i = a.length-1; i >= 0; i--) {
			result[i] *= right;
			right *= a[i];
		}
    	return result;
    }
}
