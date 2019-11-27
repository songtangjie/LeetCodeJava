package 算法;

public class Day02 {
	//迭代方式
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		//虚拟头结点
		ListNode head;
		
		//赋值头结点
		if (l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		
		ListNode cur = head;
		//串起来剩余节点
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur = cur.next = l1;
				l1 = l1.next;
			} else {
				cur = cur.next = l2;
				l2 = l2.next;
			}
		}
		
		//串完一个链表，剩下的链表直接串后面即可
		if (l1 == null) {
			cur.next = l2;
		} else if (l2 == null) {
			cur.next = l1;
		}
		
		return head;
	}
	
	//递归方式
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists2(l1.next,l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1,l2.next);
			return l2;
		}
	}
	
	//迭代虚拟头结点方式
	public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		//虚拟头结点
		ListNode head = new ListNode(0);
		
		ListNode cur = head;
		//串起来剩余节点
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur = cur.next = l1;
				l1 = l1.next;
			} else {
				cur = cur.next = l2;
				l2 = l2.next;
			}
		}
		
		//串完一个链表，剩下的链表直接串后面即可
		if (l1 == null) {
			cur.next = l2;
		} else if (l2 == null) {
			cur.next = l1;
		}
		
		return head.next;
	}
}
