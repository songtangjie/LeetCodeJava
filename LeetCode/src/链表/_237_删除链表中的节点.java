package 链表;

public class _237_删除链表中的节点 {
	/* 与下一个节点交换
	 * 时间复杂度:O(1)，空间复杂度:O(1)
	 */
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
        node.next = node.next.next;
    }
}
