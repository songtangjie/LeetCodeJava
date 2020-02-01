package 算法;


public class Day24 {
	Node1 first = null;
	Node1 last = null;
	
	/* 
	 * 中序遍历
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
    public Node1 treeToDoublyList(Node1 root) {
		if (root == null) {
			return null;
		}
		
        helper(root);
        
        last.right = first;
        first.left = last;
        return first;
    }
    
    private void helper(Node1 node) {
		
		if (node != null) {
			//遍历左边
			helper(node.left);
			
			if (last != null) {
				//交换指向
				last.right = node;
				node.left = last;
			} else {
				//当前没有前驱节点，则是最小节点
				first = node;
			}
			//当前节点是链表最大节点
			last = node;
			
			//遍历右边
			helper(node.right);
		}

	}
}


//Definition for a Node.
class Node1 {
public int val;
public Node1 left;
public Node1 right;

public Node1() {}

public Node1(int _val) {
   val = _val;
}

public Node1(int _val,Node1 _left,Node1 _right) {
   val = _val;
   left = _left;
   right = _right;
}
};
