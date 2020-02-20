package 链表;

public class _2_两数相加 {
	/* 创建虚节点和新链表
	 * 时间复杂度:O(max(m,n))，空间复杂度:O(max(m,n))
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        //进位值
        int carry = 0;
        while (l1 != null || l2 != null) {
			int v1 = 0;
			if (l1 != null) {
				v1 = l1.val;
				l1 = l1.next;
			}
			int v2 = 0;
			if (l2 != null) {
				v2 = l2.val;
				l2 = l2.next;
			}
			
			//计算加法值
			int sum = v1 + v2 + carry;
			//计算进位值
			carry = sum / 10;
			//添加新节点
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
		}
        
        //检查最高位是否有进位
        if (carry > 0) {
        	cur.next = new ListNode(carry);
		}
        return dummy.next;
    }
}
