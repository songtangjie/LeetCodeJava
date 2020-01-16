package 算法;

public class Day13 {
	
	/* 顶点法减少遍历次数【左下角】
	 * 时间复杂度:O(m+n)，时间复杂度:O(1)
	 */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        
        while (col >= 0 && row < matrix.length) {
			if (target < matrix[row][col]) {
				row--;
			} else if (target > matrix[row][col]) {
				col++;
			} else {//找到值
				return true;
			}
		}
        
        return false;
    }
	
	/* 顶点法减少遍历次数【右上角】
	 * 时间复杂度:O(m+n)，时间复杂度:O(1)
	 */
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0) {
			return false;
		}
    	
        int row = 0;
        int col = matrix[0].length-1;
        
        while (col >= 0 && row < matrix.length) {
			if (target < matrix[row][col]) {
				col--;
			} else if (target > matrix[row][col]) {
				row++;
			} else {//找到值
				return true;
			}
		}
        
        return false;
    }
	
	/* 暴力法遍历
	 * 时间复杂度:O(m*n)，时间复杂度:O(1)
	 */
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (target == matrix[i][j]) {
					return true;
				}
			}
		}
        return false;
    }
}
