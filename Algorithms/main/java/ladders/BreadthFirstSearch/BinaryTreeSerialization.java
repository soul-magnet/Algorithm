package main.java.ladders.BreadthFirstSearch;
/**
 * 7. Binary Tree Serialization - Medium -Required

Design an algorithm and write code to serialize and deserialize a binary tree. 
Writing the tree to a file is called 'serialization' and reading back from the file 
to reconstruct the exact same binary tree is 'deserialization'.

 Notice
There is no limit of how you deserialize or serialize a binary tree, 
LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.

Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

Tags : Binary Tree Microsoft Yahoo Uber
Related Problems 
Medium Strings Serialization 39 %
Medium Search Range in Binary Search Tree 37 %
 * */

import java.util.LinkedList;
import java.util.Queue;

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
class BinaryTreeSerialization {
    
    public String serialize(TreeNode root){
        if(root == null) return "{}";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        result.append("{");
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                result.append("#,");
                continue;
            }
            result.append(node.val+",");
            queue.add(node.left);
            queue.add(node.right);
        }
        result.append("}");
        return result.toString();
    }
    
    public TreeNode deserialize(String data){
        if(data == "{}") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.substring(1, data.length() - 2).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
       for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if(!values[i].equals("#")){
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.left);
            }
            
            if(!values[++i].equals("#")){
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.right);
            }
        }
        
        return root;
    }

    //another way of implementing
    public TreeNode deserialize1(String s) {
              if(s=="{}")return null;
       String[] a = s.substring(1,s.length()-2).split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        q.offer(root); int i=1;
        while(i<a.length&&!q.isEmpty()){
            TreeNode now = q.poll();
            if(!a[i].equals("#")){
                now.left=new TreeNode(Integer.parseInt(a[i]));
                q.offer(now.left);
            }i++;
            if(!a[i].equals("#")){
                now.right=new TreeNode(Integer.parseInt(a[i]));
                q.offer(now.right);
            }i++;
        }
        return root;
    }
}

