package main.java.ladders.DepthFirstSearch;
/**

The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example
  3
 / \
2   3
 \   \ 
  3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    3
   / \
  4   5
 / \   \ 
1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

Tags 
Depth First Search Uber
Related Problems 
Medium House Robber III 31 %
Medium House Robber II 28 %
Medium House Robber 34 %

 * */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class HouseRobber3 {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
      public int houseRobber3(TreeNode root) {
        if(root==null){
            return 0;
        }
        int  [] res = dp(root);
        return Math.max(res[0],res[1]);
    }

    private int[] dp(TreeNode root) {
        int res[] = new int [2];
        if(root==null){
            res[0]=0;//not choose root
            res[1]=0;//choose root
            return res;
        }
        int [] l = dp(root.left);
        int [] r = dp(root.right);
        res[0] = Math.max(l[0],l[1])+ Math.max(r[1],r[0]);
        res[1] = root.val+ l[0]+r[0];
        return res;
    }
    
        public int houseRobber31(TreeNode root) {
        if(root==null){
            return 0;
        }
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return dfs(root, map);
    }
    public int dfs(TreeNode root, HashMap map) {
        if(root==null){
            return 0;
        }
        if(map.containsKey(root)){
            return (int) map.get(root);
        }
        int l = dfs(root.left,map);
        int r= dfs(root.right, map);
        int crt = root.val;
        if(root.left!=null){
            crt += dfs(root.left.right, map)+ dfs(root.left.left, map);
        }
        if(root.right!= null){
            crt+= dfs(root.right.left, map)+ dfs(root.right.right, map);
        }
        int res = Math.max(l+r,crt);
        map.put(root,res);
        return res;
    }
}
