package binarytree;

import java.util.ArrayList;

import DataStructure.TreeNode;

/*
 *Given the root and two nodes in a Binary Tree. 
 *Find the lowest common ancestor(LCA) of the two nodes.
 *The lowest common ancestor is the node with largest depth which is the ancestor of both nodes. 
 *
 *For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

* Analysis: Compare root with p and q, then decide which way to go.
* There’s only three cases you need to consider.
 	1.Both nodes are to the left of the tree.
	2.Both nodes are to the right of the tree.
	3.One node is on the left while the other is on the right.
	4. When the current node equals to either of the two nodes, this node must be the LCA too.
* We can recursively traverse the BST from root. 
* The main idea of the solution is, while traversing from top to bottom, 
* the first node n we encounter with the value between n1 and n2, i.e, n1 < n < n2
* or same as one of the n1 or n2, is LCA of n1 and n2(assuming that n1< n2).
* So just recursively traverse the BST in, if node's value is grater than both
* n1 and n2 then our LCA lies in left side of the node,
* if it's smaller than both n1 and n2, 
* then LCA lies in left side of the node,then LCA lies on right side.
* Otherwise root us LCA(assuming that both n1 and n2 are present in BST)
* Time Complexity of above solution is O(h) where h is height of tree.
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right, parent;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class LowestCommonAncestor {
	/**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
	//updated iterative solution
// 	To find the lowest common ancestor, we need to find where is p and q and a way to track their ancestors. 
// 	A parent pointer for each node found is good for the job. 
// 	After we found both p and q, we create a set of p's ancestors. 
// 	Then we travel through q's ancestors, the first one appears in p's is our answer.
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		Map<TreeMap, TreeMap> parent = new HashMap<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		parent.put(root, null);
		stack.push(root);
		
		while(!parent.containsKey(A) || !parent.containsKey(B)){
			TreeNode node = stack.pop();
			if(node.left != null){
				parent.put(node.left, node);
				stack.push(node.left);
			}
			
			if(node.right != null){
				parent.put(node.right, node);
				stack.push(node.right);
			}
		}
		
		Set<TreeNode> ancestors = new HashSet<>();
		while(A != null){
			ancestors.add(A);
			A = parent.get(A);
		}
		
		while(!ancestors.contains(B)){
			B = parent.get(B);
		}
		
		return B;
	}
	
	
	//recursive approach
	public TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2){
		if (root == null || root == node1 || root == node2){
			return root;
		}
		
		// Divide
		TreeNode left = getAncestor(root.left, node1, node2);
		TreeNode right = getAncestor(root.right, node1, node2);
		
		// Conquer
		if (left != null && right != null){
			return root;
		}
		
		if (left != null){
			return left;
		}
		
		if (right != null){
			return right;
		}
		
		return null;
	}
	
	//recursive - elegant :)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}
}
