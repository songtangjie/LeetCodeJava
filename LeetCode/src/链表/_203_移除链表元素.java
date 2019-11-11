package 链表;

public class _203_移除链表元素 {
	
	public ListNode removeElements(ListNode head, int val) {
		
		if (head == null) return head;
		
        ListNode curNode = head;
		while (curNode != null && curNode.next != null) {
			
			if (curNode.val == val) {
				curNode = curNode.next;
			} else if (curNode.next.val == val) {
				curNode.next = curNode.next.next;
			} else {
				curNode = curNode.next;
			}
			
		}
		return head;
    }
}
