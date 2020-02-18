package 算法;

public class Day47 {
	/* 
	 * 对于A && B，如果A为假，那么就不执行B了;而如果A为真，就会执行B。
	 * 对于A || B，如果A为真，那么就会不执行B了;而如果A为假，就会执行B。
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int sumNums(int n) {
        int sum = n;
        // && 短路与 n > 0为假时，不会再进行后面的判断，递归终止
        boolean res = (n > 0) && ((sum += sumNums(n-1)) > 0);
        return sum;
    }
}
