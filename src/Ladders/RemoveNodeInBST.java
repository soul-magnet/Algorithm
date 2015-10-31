package Ladders;

public class RemoveNodeInBST {
	/**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
	public TreeNode removeNode(TreeNode root, int val) {
		
			if (root == null)
	            return null;
	        if (val < root.val)
	            root.left = removeNode(root.left, val);
	        else if (val > root.val)
	            root.right = removeNode(root.right, val);
	        else {
	            if (root.left == null)
	                return root.right;
	            if (root.right == null)
	                return root.left;
	            TreeNode x = root;
	            root = findMin(root.right);
	            root.right = deleteMin(x.right);
	            root.left = x.left;
	        }
	        return root;
	        
	}
}


