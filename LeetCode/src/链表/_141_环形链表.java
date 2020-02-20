package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 */

public class _141_环形链表 {
	/* 快慢指针
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
	public boolean hasCycle(ListNode head) {
	        
	        if (head == null || head.next == null) return false;
	        
	        ListNode slow = head;
	        ListNode fast = head.next;
	        
	        while (fast != slow) {
	            
	            if (fast == null || fast.next == null) return false;
	            
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        return true;
	}
}
