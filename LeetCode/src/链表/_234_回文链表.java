package 链表;

public class _234_回文链表 {
	/* 求出中点节点，把链表后半部分翻转
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
    public boolean isPalindrome(ListNode head) {
    	//没有节点或者只有1个节点
        if (head == null || head.next == null) return true;
        //有2个节点
        if (head.next.next == null) return head.val == head.next.val;
        
        //找到中间节点
        ListNode mid = middleNode(head);
        //翻转右半部分（中间节点的右边部分）
        ListNode rightHead = reverseList(mid.next);
        ListNode leftHead = head;
        //从lHead、rHead出发，判断是否为回文链表
        while (rightHead != null) {
			if (leftHead.val != rightHead.val) return false;
			leftHead = leftHead.next;
			rightHead = rightHead.next;
		}
        
        //还原回以前的数据结构
        mid.next = reverseList(rightHead);
        
        return true;
    }
    
    /**
     * 找到中间节点（右半部分链表头结点的前一个节点）快慢指针
     * 比如 1>2>3>2>1中的3是中间节点
     * 比如 1>2>2>1中左边第一个2是中间节点
     */
    private ListNode middleNode(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
    
	/**
	 * 翻转链表
	 * @param head 原链表的头结点
	 * 比如原链表：1>2>3>4>null，翻转之后是：4>3>2>1>null
	 * @return 翻转之后链表的头结点（返回4）
	 */
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
