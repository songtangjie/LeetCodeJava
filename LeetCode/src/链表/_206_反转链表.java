package 链表;

public class _206_反转链表 {
	/* 迭代
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
	 public ListNode reverseList(ListNode head) {
		 
		 if (head == null || head.next == null) return head;
	        
		 ListNode newHead = null;
	        
	     while (head != null) {
	    	 ListNode temp = head.next;
	    	 head.next = newHead;
	    	 newHead = head;
	    	 head = temp;
	     }
	     return newHead;
	 }
	 
	/* 递归
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */
	 public ListNode reverseList2(ListNode head) {
		 
		 if (head == null || head.next == null) return head;
	    
		 ListNode nextHead = reverseList(head.next);
		 head.next.next = head;
		 head.next = null;
		 return nextHead;
	 }
}
