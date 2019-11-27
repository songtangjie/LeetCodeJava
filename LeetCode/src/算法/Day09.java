package 算法;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unchecked")
public class Day09  {
	
	//使用位运算数组
	public boolean isValidSudoku(char[][] board) 
    {
		short[] rows = new short[9];
		short[] cols = new short[9];
		short[] boxes = new short[9];
		short cur;
        for (int row = 0; row < rows.length; row++) {
			for (int col = 0; col < cols.length; col++) {
				char num = board[row][col];
				if (num == '.') continue;
				//把1左移n位
				cur = (short)(1 << (num - '1'));
				
				if ((rows[row] & cur) != 0) return false;
				if ((cols[col] & cur) != 0) return false;
				int boxIndex = (row / 3) * 3 + col / 3;
				if ((boxes[boxIndex] & cur) != 0) return false;
				rows[row] += cur;
				cols[col] += cur;
				boxes[boxIndex] += cur;
			}
		}
        
        return true;
    }
	
	//使用boolean数组
	public boolean isValidSudoku2(char[][] board) 
    {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < rows.length; row++) {
			for (int col = 0; col < cols.length; col++) {
				char num = board[row][col];
				if (num == '.') continue;
				num -= '1';
				
				if (rows[row][num]) return false;
				if (cols[col][num]) return false;
				int boxIndex = (row / 3) * 3 + col / 3;
				if (boxes[boxIndex][num]) return false;
				rows[row][num] = true;
				cols[col][num] = true;
				boxes[boxIndex][num] = true;
			}
		}
        
        return true;
    }
	
	//使用HashSet
    public boolean isValidSudoku1(char[][] board) 
    {
		Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
			rows[i] = new HashSet<>();
			cols[i] = new HashSet<>();
			boxes[i] = new HashSet<>();
		}
        
        for (int row = 0; row < rows.length; row++) {
			for (int col = 0; col < cols.length; col++) {
				char num = board[row][col];
				if (num == '.') continue;
				int boxIndex = (row / 3) * 3 + col / 3;
				if (rows[row].contains(num)) return false;
				if (cols[col].contains(num)) return false;
				if (boxes[boxIndex].contains(num)) return false;
				rows[row].add(num);
				cols[col].add(num);
				boxes[boxIndex].add(num);
			}
		}
        
        return true;
    }
}
