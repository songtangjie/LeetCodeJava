package 算法;

public class Day06 {
	//前序遍历
    public void flatten(TreeNode root)
    {
        while (root != null) {
        	//左子树不需要操作
			if (root.left != null) {
				//保存右子树的值
				TreeNode rightTreeNode = root.right;
				//左子树替换右子树
				root.right = root.left;
				root.left = null;
				
				//寻找到最右节点，把右子树的值放过去
				TreeNode mostRightTreeNode = root;
				while (mostRightTreeNode.right != null) {
					mostRightTreeNode = mostRightTreeNode.right;
				}
				mostRightTreeNode.right = rightTreeNode;
			}
			root = root.right;
		}
    }
    
    //后序遍历
    private TreeNode prev;//记录前面的节点
    public void flatten2(TreeNode root) 
    {
        if (root == null) return;
        
        flatten2(root.right);
        flatten2(root.left);
        
        //把当前节点的右指针指向前面的节点
        if (prev != null) {
			root.right = prev;
			root.left = null;
		}
        
        prev = root;
    }
}
