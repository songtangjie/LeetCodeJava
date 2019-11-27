package 算法;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Day03 {
	//解法一：所有元素放进数组排序，然后串起来
    public ListNode mergeKLists1(ListNode[] lists) 
    {
    	if (lists == null || lists.length == 0) return null;
    	
    	List<ListNode> nodes = new ArrayList<ListNode>();
    	for (ListNode list : lists) {
    		while (list != null) {
				nodes.add(list);
				list = list.next;
			}
    	}
    	
    	nodes.sort((ListNode node1, ListNode node2) -> {
    		return node1.val - node2.val;
    	});
    	
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (ListNode node : nodes) {
    		cur = cur.next = node;
    	}
        return head.next;
    }
    
  //解法二：遍历取出链表数组第一个节点，取最小的节点，然后串起来
    public ListNode mergeKLists2(ListNode[] lists) 
    {
    	if (lists == null || lists.length == 0) return null;
    	
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while (true) {
        	int minIndex = -1;//记录最小值的索引
			for (int i = 0; i < lists.length; i++) {
				//某条链表已经取完
				if (lists[i] == null) continue;
				//比较小的赋值
				if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
					minIndex = i;
				}
			}
			
			//取出了链表数组所有的值
			if (minIndex == -1) break;
			
			//串起来节点
			cur = cur.next = lists[minIndex];
			//取出后下移
			lists[minIndex] = lists[minIndex].next;
		}
        
        return head.next;
    }
    
  //解法三：链表两两合并给第一个链表
    public ListNode mergeKLists3(ListNode[] lists) 
    {
    	if (lists == null || lists.length == 0) return null;
        
		for (int i = 1; i < lists.length; i++) {
			lists[0] = mergeTwoLists(lists[0], lists[i]);
		}
        
        return lists[0];
    }
    
	//虚拟头结点
	private ListNode head = new ListNode(0);
	//迭代虚拟头结点方式
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		head.next = null;
		
		ListNode cur = head;
		//串起来剩余节点
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur = cur.next = l1;
				l1 = l1.next;
			} else {
				cur = cur.next = l2;
				l2 = l2.next;
			}
		}
		
		//串完一个链表，剩下的链表直接串后面即可
		if (l1 == null) {
			cur.next = l2;
		} else if (l2 == null) {
			cur.next = l1;
		}
		
		return head.next;
	}
	
	//解法四：优先级队列（小顶堆），然后串起来
    public ListNode mergeKLists4(ListNode[] lists) 
    {
    	if (lists == null || lists.length == 0) return null;
    	
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode node1, ListNode node2) -> {
    		return node1.val - node2.val;
    	});
        
        for (ListNode list : lists) {
        	if (list == null) continue;
			queue.offer(list);
		}
        
        while (!queue.isEmpty()) {
			ListNode list = queue.poll();
			cur = cur.next = list;
			if (list.next != null) {
				queue.offer(list.next);
			}
		}
        
        return head.next;
    }
    
  //解法五：两两合并，分治策略
    public ListNode mergeKLists5(ListNode[] lists) 
    {
    	if (lists == null || lists.length == 0) return null;
    	
        int step = 1;
        while (step < lists.length) {
			int nextStep = step << 1;
			
			for (int i = 0; i+step < lists.length; i += nextStep) {
				lists[i] = mergeTwoLists(lists[i], lists[i+step]);
			}
			
			step = nextStep;
		}
        
        return lists[0];
    }
}
