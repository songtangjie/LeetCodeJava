package 栈_队列;

import java.util.Stack;

public class _739_每日温度 {
    /* 
	 * 利用栈求出右边最近比该元素大的索引
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] dailyTemperatures(int[] T) {
    	if (T == null || T.length == 0) return null;
    	int[] result = new int[T.length];
    	Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				result[stack.peek()] = i - stack.peek();
				stack.pop();
			}
			
			stack.push(i);
		}
    	return result;
    }
    
    /* 
	 * 倒推法，相邻双指针遍历
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public int[] dailyTemperatures2(int[] T) {
    	if (T == null || T.length == 0) return null;
    	int[] values = new int[T.length];
    	int n = T.length;
    	
    	for (int i = n-2; i >= 0; i--) {
    		int j = i + 1;
			while (true) {
				if (T[i] < T[j]) {//当前值比后面值小
					values[i] = j - i;
					break;
				} else if (values[j] == 0) {//后面值已经是最大
					values[i] = 0;
					break;
				}
//				else if (T[i] == T[j]) {//两个值一样
//					values[i] = values[j] + j - i;
//					break;
//				}
				//当前值比较大，则查找后面区间里的最大值
				j = j + values[j];
			}
		}
    	return values;
    }
}
