package 链表;

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

public class _708_循环有序列表的插入 {
	/* 
	 * 三种情况判断插入位置，双指针
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
	 public Node insert(Node head, int insertVal) {
		if (head == null) {
			Node newNode = new Node(insertVal, null);
			newNode.next = newNode;
			return newNode;
		}
		 
		Node pre = head;
		Node cur = head.next;
		boolean needInsert = false;
		
		do {
			if (pre.val <= insertVal && insertVal <= cur.val) {//当位于当前链表的最小值和最大值之间
				needInsert = true;
			} else if (pre.val > cur.val) {
				if (insertVal >= pre.val || insertVal <= cur.val) {//值小于最小值或大于最大值
					needInsert = true;
				}
			}
			
			if (needInsert) {
				pre.next = new Node(insertVal, cur);
				return head;
			}
			
			pre = cur;
			cur = cur.next;
		} while (pre != head);
		
		//链表的元素的值相同
		pre.next = new Node(insertVal, cur);
		return head;
	 }
}
