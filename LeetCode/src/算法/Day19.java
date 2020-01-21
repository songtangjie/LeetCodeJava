package 算法;

public class Day19 {
	/* 
	 * 遍历，找到重复数则直接跳过
	 */
	public ListNode deleteDuplicates(ListNode head) {
		//虚节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {//下个节点值和下下个一样
				ListNode temp = cur.next;
				while (temp != null && temp.next != null && temp.val == temp.next.val) {//间隔几个就跳过
					temp = temp.next;
				}
				//跳过中间重复数字
				cur.next = temp.next;
			} else {
				cur = cur.next;
			}
		}
		
		return dummy.next;
	}
}
