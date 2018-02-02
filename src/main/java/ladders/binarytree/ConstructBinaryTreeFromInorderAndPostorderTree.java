package binarytree;

import DataStructure.TreeNode;

/* Given inorder and postorder traversal of a tree, 
 * construct the binary tree.
 * Example: Given inorder [1,2,3] and postorder [1,3,2], return a tree:

  2
 / \
1   3
Note: You may assume that duplicates do not exist in the tree.
 * Analysis:
 * From the post order array we know that last element is root. 
 * We can find the root in inorder array. Then we can identify the left and right sub-trees
 * and right sub-trees in post-order array. Recursively, we can build up a tree.
 * 
 * */
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
public class ConstructBinaryTreeFromInorderAndPostorderTree {
	/**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;
        
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, 
    		int[] postorder, int postStart, int postEnd){
    	if (inStart > inEnd || postStart > postEnd)
    		return null;
    	int rootValue = postorder[postEnd];
    	TreeNode root = new TreeNode(rootValue);
    	
    	int k = 0;
    	for (int i = 0; i < inorder.length; i++){
    		if (inorder[i] ==rootValue){
    			k = i;
    			break;
    		}
    	}
    	
    	root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, 
    			postStart + k - (inStart + 1));
    	// Becuase k is not the length, it it need to -(inStart+1) to get the length
    	root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd -1);
    	// Becuase k is not the length, it it need to -(inStart+1) to get the length
    	
    	return root;
    }
    
    /*
     private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
            int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);
        int position = findPosition(inorder, instart, inend, postorder[postend]);

        root.left = myBuildTree(inorder, instart, position - 1,
                postorder, poststart, poststart + position - instart - 1);
        root.right = myBuildTree(inorder, position + 1, inend,
                postorder, poststart + position - instart, postend - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }*/
}
