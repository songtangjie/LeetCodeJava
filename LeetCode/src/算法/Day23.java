package 算法;

import java.util.HashMap;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

public class Day23 {
	
	/* 
	 * 新节点穿插在旧的中间
	 * 时间复杂度:O(n)，空间复杂度:O(1)
	 */	
	public Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}
		
		Node ptr = head;
		while (ptr != null) {
			Node newNode = new Node(ptr.val, null, null);
			
		    // 串起来复制的节点 A->A'->B->B'->C->C'
			newNode.next = ptr.next;
			ptr.next = newNode;
			ptr = newNode.next;
		}
		
		ptr = head;
		
		//把复制的节点的random指针指向新复制的节点
		while (ptr != null) {
			ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
			ptr = ptr.next.next;
		}
		
		Node ptr_old_list = head;
		Node ptr_new_list = head.next;
		Node head_old = head.next;
		while (ptr_old_list != null) {
			ptr_old_list.next = ptr_old_list.next.next;
			ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
			ptr_old_list = ptr_old_list.next;
			ptr_new_list = ptr_new_list.next;
		}
		return head_old;
	}
	
	HashMap<Node, Node> visited = new HashMap<Node, Node>();
	/* 
	 * 迭代法
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
	public Node copyRandomList2(Node head) {
		if (head == null) {
			return head;
		}
		
		Node oldNode = head;
		
		Node newNode = new Node(oldNode.val, null, null);
		this.visited.put(oldNode, newNode);
		
		while (oldNode != null) {
			newNode.random = this.getCloneNode(oldNode.random);
			newNode.next = this.getCloneNode(oldNode.next);
			
			oldNode = oldNode.next;
			newNode = newNode.next;
		}
		return this.visited.get(head);
	}
	
	//集合中获取是否已经存储节点
	public Node getCloneNode(Node node) {
		if (node != null) {
			if (!this.visited.containsKey(node)) {
				this.visited.put(node, new Node(node.val, null, null));
			}
			return this.visited.get(node);
		}
		return null;
	}
	
	HashMap<Node, Node> visitedHashMap = new HashMap<Node, Node>();
	/* 
	 * 回溯法
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
	public Node copyRandomList1(Node head) {
		if (head == null) {
			return head;
		}
		
		//map中已经存储了节点则直接返回,否则就创建新节点
		if (this.visitedHashMap.containsKey(head)) {
			return this.visitedHashMap.get(head);
		}
		
		Node node = new Node(head.val,null,null);
		this.visitedHashMap.put(head, node);
		
		//递归查找
		node.next = this.copyRandomList1(head.next);
		node.random = this.copyRandomList1(head.random);
		
		return node;
	}
}
