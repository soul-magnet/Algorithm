package Ladders;

import java.util.ArrayList;

/*Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *         
 *     }
 * }
 */
// Go though each solution implemented below, there are 3 approaches to solve this problem.

public class LowestCommonAncestor {
 // If we are not dealing with parent node
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B)
    
    {
        if (root == null || root == A || root == B){
            return root;
        }
            
           

        TreeNode l = lowestCommonAncestor(root.left, A, B);
        TreeNode r = lowestCommonAncestor(root.right, A, B);

        if (l != null && r != null) {
    	   return root;  // nodes are each on a separate branch
        }

            // either one node is on one branch, 
            // or none was found in any of the branches
        return l != null ? l : r;
        
    }

// If we are dealing with parent node

//private TreeNode getRoot( TreeNode node) {
//    while (node.parent != null) {
//        node = node.parent;
//    }
//    return node;
//}
//
//private TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
//    if (root == null || root == node1 || root == node2) {
//        return root;
//    }
//    
//    // Divide
//    TreeNode left = getAncestor(root.left, node1, node2);
//    TreeNode right = getAncestor(root.right, node1, node2);
//    
//    // Conquer
//    if (left != null && right != null) {
//        return root;
//    } 
//    if (left != null) {
//        return left;
//    }
//    if (right != null) {
//        return right;
//    }
//    return null;
//}
//
//public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2) {
//    if (node1 == null || node2 == null) {
//        return null;
//    }
//    TreeNode root = getRoot(node1);
//    return getAncestor(root, node1, node2);
//}

// Traditional Approach

  /*  private ArrayList<TreeNode> getPath2Root(TreeNode node) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        while (node != null) {
            list.add(node);
            node = node.parent;
        }
        return list;
    }
    public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2) {
        ArrayList<TreeNode> list1 = getPath2Root(node1);
        ArrayList<TreeNode> list2 = getPath2Root(node2);
        
        int i, j;
        for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (list1.get(i) != list2.get(j)) {
                return list1.get(i).parent;
            }
        }
        return list1.get(i+1);
    }*/
}
