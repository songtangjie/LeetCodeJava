package 算法;

import java.util.LinkedList;

public class Day46 {
	/* 
	 * 数学递推式f(i)=(f(i−1)+m)%i
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
    public int lastRemaining1(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
        
        return last;
    }
    
	/* 
	 * 链表方式，找到则把剩余节点插入链表末尾
	 * 时间复杂度:O(m*n)，空间复杂度:O(n)
	 */	
    public int lastRemaining2(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
			list.add(i);
		}
        
        while (list.size() != 1) {
			for (int i = 0; i < m; i++) {
				Integer pre = list.pollFirst();
				//把之前一个元素放入链表末尾
				if (i != m-1) {
					list.add(pre);
				}
			}
		}
        
        //剩余最后一个元素
        return list.pollFirst();
    }
}
