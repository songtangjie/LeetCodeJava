package 高频题;

public class _50_Pow {
	/* 
	 * 分治迭代
	 * 时间复杂度:O(logn)，空间复杂度:O(1)
	 */	
    public double myPow(double x, int n) {
    	long y = (n < 0) ? -((long) n) : n;
    	double res = 1.0;
    	while (y > 0) {
			if ((y & 1) == 1) {
				// 如果最后一个二进制位是1，就累乘上x【奇数n】
				res *= x;
			}
			x *= x;
			// 舍弃掉最后一个二进制位【除2】
			y >>= 1;
		}
    	return (n < 0) ? (1 / res) : res;
    }
    
    /* 
	 * 分治递归
	 * 时间复杂度:O(logn)，空间复杂度:O(logn)
	 */	
    public double myPow2(double x, int n) {
    	if (n == 0) return 1;
    	if (n == -1) return 1 / x;
    	double half = myPow2(x, n >> 1);
    	half *= half;
    	// 是否为奇数
    	return ((n & 1) == 1) ? (half * x) : half;
    }
    
    /* 
	 * 扩展：结果再求余，分治迭代
	 * 时间复杂度:O(logn)，空间复杂度:O(1)
	 */	
    public static int powMod(int x, int y, int z) {
    	if (y < 0 || z == 0) return 0;
    	int res = 1 % z;
    	x %= z;
    	
    	while (y > 0) {
			if ((y & 1) == 1) {
				// 如果最后一个二进制位是1，就累乘上x【奇数n】
				res = (res * x) % z;
			}
			x = (x * x) % z;
			// 舍弃掉最后一个二进制位【除2】
			y >>= 1;
		}
    	return res;
    }
    
    /* 
	 * 扩展：结果再求余，分治递归
	 * 时间复杂度:O(logn)，空间复杂度:O(logn)
	 */	
    public static int powMod2(int x, int y, int z) {
    	if (y < 0 || z == 0) return 0;
    	if (y == 0) return 1 % z;
    	int half = powMod2(x, y >> 1, z);
    	half *= half;
    	// 是否为奇数
    	return ((y & 1) == 1) ? ((half * (x % z)) % z) : (half % z);
    }
    
    public static void main(String[] args) {
        System.out.println(powMod2(-123, 455, 789));
        System.out.println(powMod(-123, 455, 789));
    }
}
