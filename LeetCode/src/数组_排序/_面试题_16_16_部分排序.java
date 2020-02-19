package 数组_排序;

public class _面试题_16_16_部分排序 {
	/* 指针寻找逆序对
	 * 时间复杂度:O(1)，空间复杂度:O(1)
	 */
    public int[] subSort(int[] array) {
        if (array.length == 0) {
			return new int[] {-1,-1};
		}
        
        // 从左扫描到右寻找逆序对（正序：逐渐变大）
        int max = array[0];
        // 用来记录最右的那个逆序对位置
        int right = -1;
        for (int i = 1; i < array.length; i++) {
        	int v = array[i];
			if (v >= max) {
				max = v;
			} else {
				right = i;
			}
		}
        
        //找不到有边界值，则数组是已经排序好的
        if (right == -1) {
        	return new int[] {-1,-1};
		}
        
        // 从右扫描到左寻找逆序对（正序：逐渐变小）
        int min = array[array.length-1];
        // 用来记录最左的那个逆序对位置
        int left = -1;
        for (int i = array.length-2; i >= 0; i--) {
        	int v = array[i];
			if (v <= min) {
				min = v;
			} else {
				left = i;
			}
		}
        
        return new int[] {left,right};
    }
}
