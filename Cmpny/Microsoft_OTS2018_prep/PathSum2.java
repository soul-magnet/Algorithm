package Microsoft_OTS2018_prep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import main.java.ladders.util.TreeNode;

/** LeetCode
 * 13. Path Sum II - Medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

Related Topics: Tree, DFS

Similar Questions 
Path Sum
Binary Tree Paths
Path Sum III
Path Sum IV
 * */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum2 {
	//DFS Approach
	private List<List<Integer>>result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if(root == null) return result;
    	Stack<Integer>path = new Stack<Integer>();
    	dfs(root, sum, path);
    	return result;
    }
    
    public void dfs(TreeNode root, int sum, Stack<Integer>path) {
    	path.push(root.val);
    	if((root.left == null && root.right == null) || root.val == sum)
    		result.add(new ArrayList<Integer>(path));
    	if(root.left != null) 
    		dfs(root.left, sum-root.val, path);
    	if(root.right != null)
    		dfs(root.right, sum-root.val, path);
    	path.pop();
    }
    
   
    //Same Approach DFS: Using ArrayList instead of Stacks
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(root==null) return resultList;
        List<Integer> currentPath = new ArrayList<Integer>();
        pathSumInner(root, sum, currentPath, resultList);
        return resultList;
    }
    
    public void pathSumInner(TreeNode root, int sum, List<Integer>path, List<List<Integer>> result) {
        path.add(root.val);
        if(root.left == null && root.right == null)
            if(sum == root.val) result.add(new ArrayList<Integer>(path));
        if(root.left!=null) pathSumInner(root.left, sum-root.val, path, result);
        if(root.right!=null)pathSumInner(root.right, sum-root.val, path, result);
        path.remove(path.size()-1);
    }
    
    //Iterative Approach
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int SUM = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                SUM+=cur.val;
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=pre){
                cur = cur.right;
                continue;
            } 
            if(cur.left==null && cur.right==null && SUM==sum) 
                res.add(new ArrayList<Integer>(path));
  
            pre = cur;
            stack.pop();
            path.remove(path.size()-1);
            SUM-=cur.val;
            cur = null;
        
        }
        return res;
    }
}

