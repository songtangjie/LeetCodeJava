package 链表;

public class _86_分隔链表 {
	/* 双指针，注意尾部节点
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode leftHead = new ListNode(0);
        ListNode leftTail = leftHead;
        
        ListNode rightHead = new ListNode(0);
        ListNode rightTail = rightHead;
        
        while (head != null) {
			if (head.val < x) {
				leftTail.next = head;
				leftTail = leftTail.next;
			} else {
				rightTail.next = head;
				rightTail = rightTail.next;
			}
			head = head.next;
		}
        
        /* 最后一个节点要指向空
         * 因为可能出现这样的情况:
         * 原链表倒数第N个节点A的值是>=x的，A后面所有节点的值都是<x的
         * 然后rTail.next最终其实就是A.next
         */
        rightTail.next = null;
        // 合并两条链表
        leftTail.next = rightHead.next;
        return leftHead.next;
    }
}
