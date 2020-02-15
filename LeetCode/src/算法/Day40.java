package 算法;

public class Day40 {
	/* 
	 * 两个掩码异或位运算
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int[] singleNumber(int[] nums) {
    	//x和y的差异，不会保留出现2次的数字
        int bitmask = 0;
        for (int num : nums) {
			bitmask ^= num;
		}
        
        //提取最右边的1
        int diff = bitmask & (-bitmask);
        
        //遍历查找x
        int x = 0;
        for (int num : nums) {
			if ((num & diff) != 0) {
				x ^= num;
			}
		}
        
        return new int[]{x, bitmask ^ x};
    }
}
