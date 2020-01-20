package 算法;

public class Day17 {
	/* 快慢指针
	 * 时间复杂度:O(L)链表节点长度，空间复杂度:O(1)
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
			return null;
		}
        
        //虚节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 1; i <= n+1; i++) {
        	first = first.next;
        	if (first == null) {
				return dummy.next;
			}
		}
        
        while (first != null) {
        	first = first.next;
        	second = second.next;
		}
        //找到删除节点的前一个节点
        second.next = second.next.next;
        
        return dummy.next;
    }
}
