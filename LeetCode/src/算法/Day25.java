package 算法;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class Day25 {

	/* 
	 * 前序遍历
	 * 时间复杂度:O(n)，空间复杂度:O(n)
	 */	
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
    
    private String rserialize(TreeNode root, String str) {
        if (root == null) {
			str += "null,";
		} else {
			str += str.valueOf(root.val) + ",";
			str = rserialize(root.left, str);
			str = rserialize(root.right, str);
		}
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
    
    private TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}
        
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        
        return root;
    }
}
