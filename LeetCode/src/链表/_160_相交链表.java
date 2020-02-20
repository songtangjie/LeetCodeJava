package 链表;

public class _160_相交链表 {
	/* 遍历链表，遍历结束交叉遍历
	 * 时间复杂度:O(m+n))，空间复杂度:O(1)
	 */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
			return null;
		}
        
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
			curA = (curA == null) ? headB : curA.next;
			curB = (curB == null) ? headA : curB.next;
		}
        
        return curA;
    }
}
