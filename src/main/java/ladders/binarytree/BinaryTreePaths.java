package main.java.ladders.binarytree;
/**
 * 480. Binary Tree Paths - Easy - Required

Given a binary tree, return all root-to-leaf paths.

Have you met this question in a real interview? 
Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

Tags: Binary Tree Google Binary Tree Traversal Facebook
Related Problems 
Medium Tree Longest Path With Same Value 14 %

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
public class BinaryTreePaths {
	/**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */

    //Solution 1: Divide and Conquer; Total Runtime: 4495 ms

    
   /*public List<String> binaryTreePaths(TreeNode root) {
        List<String> result  = new ArrayList<String>();
        
        if(root == null){
            return result;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        
        
        for(String node : leftPaths){
            result.add(root.val + "->" + node);
        }
        
        for(String node : rightPaths){
            result.add(root.val + "->" +  node);
        }
        
        if(result.size() == 0){
            result.add("" + root.val);
        }
        
        return result;
    }*/
    
    //Solution 2: Traverse; Total Runtime: 4064 ms
    
   /* public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        
        if(root == null){
            return result;
        }
        
        dfs(root, String.valueOf(root.val), result);
        return result;
    }
    
    private void dfs(TreeNode root, String node, List<String> result){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            result.add(node);
            return;
        }
        
        if(root.left != null){
            dfs(root.left, node + "->" + String.valueOf(root.left.val), result);
        }
        
        if(root.right != null){
            dfs(root.right, node + "->" + String.valueOf(root.right.val), result);
        }
    }*/
    
    //Traverse; Total Runtime: 2583 ms
    /*public List<String> binaryTreePaths(TreeNode root) {
    	List<String> rst = new ArrayList<String>();
    	if (root == null) {
    		return rst;
    	}
    	helper(root, rst, new ArrayList<Integer>());
    	return rst;
    }

    public void helper(TreeNode root, List<String> rst, ArrayList<Integer> list){
    	list.add(root.val);
    	if (root.left == null && root.right == null) {
    		StringBuffer sb = new StringBuffer();
    		for (int i = 0; i < list.size() - 1; i++) {
    			sb.append(list.get(i) + "->");
    		}
    		sb.append(list.get(list.size() - 1));
    		rst.add(sb.toString());
    	}
    	if (root.left != null) {
    		helper(root.left, rst, list);
    		list.remove(list.size() - 1);
    	}
    	if (root.right != null) {
    		helper(root.right, rst, list);
    		list.remove(list.size() - 1);
    	}
    }*/
    
    //Iterative: Use Stacks
    
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> rst = new ArrayList<String>();
    	if (root == null) {
    		return rst;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	stack.push(root);

    	Stack<Integer> levels = new Stack<Integer>();
    	levels.push(0);

    	while (!stack.isEmpty()) {
    		int lv = levels.pop();
    		TreeNode node = stack.pop();
    		list.add(node.val);
    		
    		if (node.left == null && node.right == null) {
				StringBuffer sb = new StringBuffer();
	    		for (int i = 0; i < list.size() - 1; i++) {
	    			sb.append(list.get(i) + "->");
	    		}
	    		sb.append(list.get(list.size() - 1));
	    		rst.add(sb.toString());
	    		while (!levels.isEmpty() && list.size() > levels.peek()) {
	    			list.remove(list.size() - 1);
	    		}
    		}
    		
    		if (node.right != null) {
    			stack.push(node.right);
    			levels.push(lv + 1);	
    		}
    		if (node.left != null) {
    			stack.push(node.left);
    			levels.push(lv + 1);
    		}

    	}//end while

    	return rst;
    }

}
