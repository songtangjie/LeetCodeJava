package 算法;

public class Day16 {
	/* 双指针交换
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
    public int[] sortArrayByParity(int[] A) {
        int pre = 0;
        int last = A.length - 1;
        while (pre < last) {
        	//前一个数为偶数
			while (pre < last && A[pre] % 2 == 0) {
				pre++;
			}
			//后一个数为奇数
			while (pre < last && A[last] % 2 != 0) {
				last--;
			}
			
			//前奇后偶
			if (pre < last) {
				int temp = A[pre];
				A[pre] = A[last];
				A[last] = temp;
			}
		}
        return A;
    }
}
