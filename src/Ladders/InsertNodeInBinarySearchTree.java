package Ladders;

/**
* Definition of TreeNode:
* public class TreeNode {
*     public int val;
*     public TreeNode left, right;
*     public TreeNode(int val) {
*         this.val = val;
*         this.left = this.right = null;
*     }
* }
*/

public class InsertNodeInBinarySearchTree {
	
	/**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
	// Version II
	/*public TreeNode insertNode (TreeNode root, TreeNode node) {
        
        if (root == null) {
            return node;
        }
        if (root.val > node.val){
            root.left = insertNode(root.left, node);
        } else {
            
            root.right = insertNode(root.right, node);
        }
        
        return root;
         
         
     }*/
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null){
            root = node;
            return root;
        }
        
        TreeNode tmp = root;
        TreeNode last = null;
        
        while(tmp != null) {
            last = tmp;
            if (tmp.val > node.val){
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        
        if (last != null){
            if (last.val > node.val){
                last.left = node;
            } else {
                last.right = node;
            }
        }
        
        return root;
    }

}
