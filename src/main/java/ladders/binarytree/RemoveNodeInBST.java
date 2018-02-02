package binarytree;

import DataStructure.TreeNode;

/*
 * Given a root of Binary Search Tree with unique value for each node.  
 * Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. 
 * You should keep the tree still a binary search tree after removal.
 * Example
Given binary search tree:

          5

       /    \

    3          6

 /    \

2       4

Remove 3, you can either return:

          5

       /    \

    2          6

      \

         4

or :

          5

       /    \

    4          6

 /   

2
 * Analysis:
 * 1. Node to be removed has no children 
 * This case is quite simple. Algorithm sets corresponding link of the parent to NULL
 * and disposes the node. 
 * 
 * 2. Node to be removal has one child.
 * It this case, node is cut from the tree and algorithm links single child
 * (with it's subtree) directly to the parent of removed node.
 * 
 * 3. Node to be removed has two children
 * This is the most complex case. To solve it, let us see one useful BST property first.
 * We are going to use the idea, that the same set of values may be represented as different binary-search trees.
 * For example: 
 *              5                      19
 *               \                    /  \
 *               21 ---->            5    21
 *              /  \                       \
 *             19  25                      25           
 * 
 * contains same values {5, 19, 21, 25}. To transform first tree into second one;
 * - choose minimum element from right subtree (19 in the example)
 * - replace 5 by 19
 * - hang 5 as a left child
 * 
 * The same approach can be utilized to remove a node, which has two children:
 * - find a minimum value in the right subtree;
 * - replace value of the node to be removed with found minimum.
 *   Now, right subtree contains a duplicate!
 * - Apply remove to the right subtree to remove a duplicate
 * 
 * Notice that the node with minimum value has no left child and, therefore
 * it's removal may result in first or second cases only.
 * ---- remove 12 -------19 is the smallest leaf on right sub-tree
 *               5                              5
 *              / \                            / \
 *             2  12                          2  19-->duplicate
 *            / \ / \ --------->             / \ / \
 *          -4  3 9 21                     -4  3 9  21
 *                 /  \                             / \
 *                19  25                duplicate--19 25 
 *
 * 
 * Reference: http://www.algolist.net/Data_structures/Binary_search_tree/Removal
 * 
 * */
public class RemoveNodeInBST {
	/**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
	
	public TreeNode removeNode (TreeNode root, int value){
		TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
	}
	
	private TreeNode findNode(TreeNode parent, TreeNode node, int value){
		if (node == null){
			return parent;
		}
		if (node.val == value){
			return parent;
		}
		if (value < node.val){
			return findNode(node, node.left, value);
		} else {
			return findNode(node, node.right, value);
		}
	}
	
	private void deleteNode(TreeNode parent, TreeNode node){
		if (node.right == null){
			if (parent.left == node){
				parent.left = node.left;
			} else {
				parent.right = node.left;
			}
		} else {
			TreeNode temp = node.right;
			TreeNode father = node;
			
			while (temp.left != null){
				father = temp;
				temp = temp.left;
			}
			
			if (father.left == temp){
				father.left = temp.right;
			} else {
				father.right = temp.right;
			}
			
			if (parent.left == node){
				parent.left = temp;
			} else {
				parent.right = temp;
			}
			temp.left = node.left;
			temp.right = node.right;
		}
	}
	
	
	// Another approach
  public TreeNode removeNode2(TreeNode root, int value) {
    // the idea is that: first search for the target node, then check
    // its children, if no children then just remove current node, we also
    // have to keep pareant node.
    // If only one node, swap the value with child and remove child.
    // If two children, swap value with predecessor and call remove method
    // on predecessor.
    if (root == null) {
        return root;
    }
    // solution line number - 5: actual line number.
    // TreeNode a = null;
    // TreeNode b = a.left;
    
    TreeNode runner = root;
    TreeNode parent = null;
    
    while (runner != null && runner.val != value) {
        parent = runner;
        if (runner.val < value) {
            runner = runner.right;
        } else {
            runner = runner.left;
        }
    }
    
    if (runner == null) {
        // cannot find the target
        return root;
    }
    
    // runner now is the target node.
    // parent node is runner's parent.
    if (runner.left == null && runner.right == null) {
        if (parent == null) {
            // removing root.
            return null;
        }
        if (parent.left == runner) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    } else if (runner.left == null || runner.right == null) {
        if (parent == null) {
            // removing root that has one subtree
            root = runner.left == null? runner.right : runner.left;
        } else if (parent.left == runner) {
            parent.left = runner.left == null? runner.right : runner.left;
        } else {
            parent.right = runner.left == null? runner.right : runner.left;
        }
    } else {
        // has two children.
        TreeNode pre = runner.left;
        TreeNode preParent = null;
        
        while (pre.right != null) {
            preParent = pre;
            pre = pre.right;
        }
        
        // if preParent is null, parent is runner.
        runner.val = pre.val;
        // Key observation here: predecessor can either has no children
        // or at most has only left child.
        if (pre.left == null) {
            if (preParent == null) {
                runner.left = null;
            } else {
                preParent.right = null;
            }
        } else {
            // predecessor has left substree.
            if (preParent == null) {
                runner.left = pre.left;
            } else {
                preParent.right = pre.left;
            }
        }


        // #####or:
        // // key observation here: predecessor could have no children 
        // // or only one left subtree.
        // if (pre.left == null) {
        //     // remove the pre.
        //     if (preParent.left == pre) {
        //         preParent.left = null;
        //     } else {
        //         preParent.right = null;
        //     }
        // } else {
        //     if (preParent.left == pre) {
        //         preParent.left = pre.left;
        //     } else {
        //         preParent.right = pre.left;
        //     }
        // }
        
    }
    
    return root;
  }
	
	
}
