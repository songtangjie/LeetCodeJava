package 链表;

public class _203_移除链表元素 {
	/* 创建虚节点和新链表
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
	public ListNode removeElements(ListNode head, int val) {
		
		if (head == null) return head;
		//新链表头结点
        ListNode newHead = new ListNode(0);
        //新链表尾节点
        ListNode newTail = newHead;
        
		while (head != null) {
			//值不相等则串到新链表
			if (head.val != val) {
				newTail.next = head;
				newTail = newTail.next;
			}
			
			head = head.next;
		}
		//最后一个节点指向空
		newTail.next = null;
		
		return newHead.next;
    }
}
