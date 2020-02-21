package 链表;

public class _25_K个一组翻转链表 {
	/* 
	 * 原链表分为:已翻转部分+待翻转部分+未翻转部分，分k个一组进行旋转
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //待翻转链表之前一个节点
        ListNode pre = dummy;
        //待翻转链表最后一个节点
        ListNode end = dummy;
        
        while (end != null) {
        	//移动end到待翻转链表最后一个节点
        	for (int i = 0; i < k && end != null; i++) end = end.next;
        	//不够范围元素则不翻转
        	if (end == null) break;
        	
        	//确定翻转链表范围
        	ListNode start = pre.next;
			ListNode next = end.next;
			end.next = null;
			pre.next = reverseList(start);
			start.next = next;
			pre = start;
			
			end = pre;
		}
        
        return dummy.next;
    }
    
    //翻转链表
    private ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			
			cur = next;
		}
		return pre;
	}
}
