package main.java.ladders.DynamicProgramming;
/**
 *164. Unique Binary Search Trees II - Medium

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

Have you met this question in a real interview? 
Example
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
Tags:Dynamic Programming Depth First Search

Related Problems 
Medium Generate Parentheses 37 % 
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
public class UniqueBinarySearchTrees2 {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
     public List<TreeNode> generateTrees(int n) {

         return dfs(1,n);
    }

    private  List<TreeNode>  dfs(int l, int r) {
         List<TreeNode> res = new ArrayList<>();
        if( l> r){
            res.add(null);
            return res;
        }
        for( int i=l;i<=r;i++){
            List<TreeNode> resl= dfs(l,i-1) ;
            List<TreeNode> resR= dfs(i+1,r);
            for(TreeNode l1: resl){
                for(TreeNode r1: resR){
                    TreeNode root = new TreeNode(i);
                    root.left=l1;
                    root.right=r1;
                    res.add(root);
                }
            }
        }
        return res;
    }
}