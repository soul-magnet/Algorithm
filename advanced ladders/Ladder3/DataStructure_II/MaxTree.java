package Ladder3.DataStructure_II;

import java.util.Stack;

/**
 * 126. Max Tree 

Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.

Example
Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:

    6
   / \
  5   3
 /   / \
2   0   1
Challenge 
O(n) time and memory.

Tags 
Stack LintCode Copyright Cartesian Tree
Related Problems 
Hard Largest Rectangle in Histogram 28 %
Medium Min Stack 33 %
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
public class MaxTree {
	public TreeNode maxTree(int[] a) {
        if(a==null || a.length==0) {
            return null;
        }
        Stack <TreeNode> st = new Stack<TreeNode>();
        st.push(new TreeNode(a[0]));
        for( int i=1; i< a.length;i++){
            if(a[i]<=st.peek().val){
                st.push(new TreeNode(a[i]));
            }else{
                while(!st.isEmpty()&&st.peek().val<a[i]){
                    TreeNode crt = st.pop();
                    if(st.isEmpty()||a[i]<=st.peek().val){
                        TreeNode now = new TreeNode(a[i]);
                        now.left = crt;
                        st.push(now);
                        break;
                    }else{
                        st.peek().right= crt;
                    }
                }
            }
        }
        TreeNode root = st.pop();
        while(!st.isEmpty()){
            TreeNode crt = st.pop();
            crt.right =root;
            root= crt;
        }
        return root;
    }

}

//Juizhang Solution
/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */
public class Solution {
  /**
   * @param A
   *            : Given an integer array with no duplicates.
   * @return: The root of max tree.
   */
  public static TreeNode maxTree(int[] A) {
    // write your code here
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode root = null;
    for (int i = 0; i <= A.length; i++) {
      TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
          : new TreeNode(A[i]);
      while (!stack.isEmpty()) {
        if (right.val > stack.peek().val) {
          TreeNode nodeNow = stack.pop();
          if (stack.isEmpty()) {
            right.left = nodeNow;
          } else {
            TreeNode left = stack.peek();
            if (left.val > right.val) {
              right.left = nodeNow;
            } else {
              left.right = nodeNow;
            }
          }
        } else
          break;
      }
      stack.push(right);
    }
    return stack.peek().left;
  }
}
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
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode[] stk = new TreeNode[len];
        for (int i = 0; i < len; ++i)
            stk[i] = new TreeNode(0);
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            TreeNode tmp = new TreeNode(A[i]);
            while (cnt > 0 && A[i] > stk[cnt-1].val) {
                tmp.left = stk[cnt-1];
                cnt --;
            }
            if (cnt > 0)
                stk[cnt - 1].right = tmp;
            stk[cnt++] = tmp;
        }
        return stk[0];
    }
}
