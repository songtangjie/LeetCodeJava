package 算法;

public class Day48 {
	/* 
	 * a+b = (a ^ b) + ((a & b) << 1),其中((a & b) << 1)表示进位
	 * 时间复杂度:O(1)，空间复杂度:O(1)
	 */	
    public int add(int a, int b) {
        while (a != 0) {
			int temp = a ^ b;//相加各位的值
			a = (a & b) << 1;//计算进位的值
			b = temp;//让b作为temp（相加各位的值的结果），再和a（进位）去异或，就是相加操作，
		}
        return b;
    }
}
