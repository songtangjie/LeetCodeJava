package 算法;

import java.util.PriorityQueue;

public class Day26 {
	
	/* 
	 * 大根堆、小根堆
	 * 时间复杂度:O(logn)，空间复杂度:O(n)
	 */	
	
	private int count;
	private PriorityQueue<Integer> maxheap;//大根堆
	private PriorityQueue<Integer> minheap;//小根堆
	
    /** initialize your data structure here. */
    public Day26() {
        count = 0;
        maxheap = new PriorityQueue<Integer>((x,y) -> y-x);
        minheap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
			maxheap.add(minheap.poll());
		}
    }
    
    public double findMedian() {
        if ((count & 1) == 0) {
        	// 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
        	return (double)(maxheap.peek() + minheap.peek()) / 2;
		} else {
			// 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
			return (double)maxheap.peek();
		}
    }
}
