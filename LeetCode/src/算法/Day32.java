package 算法;

public class Day32 {
	/* 
	 * 递归除2、3、5，结果为1则为丑数
	 * 时间复杂度:O(1)，空间复杂度:O(1)
	 */	
    public boolean isUgly(int num) {
        if (num == 0) {
			return false;
		}
        
        while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
				continue;
			}
			
			if (num % 3 == 0) {
				num /= 3;
				continue;
			}
			
			if (num % 5 == 0) {
				num /= 5;
				continue;
			}
			
			return false;
		}
        return true;
    }
}
