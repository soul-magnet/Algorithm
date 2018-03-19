package Google;
/**
 * 
 * Thoughts:
 * This question has two approaches, one is the breadth-first search, 
 * with the first node in each layer to update the answer. 
 * Second, the depth-first search, 
 * when the depth of a node is greater than the maximum depth currently maintained 
 * when using this node to update the answer.
 * Use the breadth-first search bfs to update Ans with the first node of each tier. Time complexity O (n).
 * Using depth-first search dfs, when we first access a node x with a depth of less than a depth, 
 * x must be the leftmost node of the depth and update Ans with this node. 
 * That is, we maintain a maximum depth, when traversing to a point depth greater than the maximum depth, 
 * use this node to update the answer, and update the maximum depth can be. Time complexity O (n).
*/
//Juizhang SOlution
public class FindBottomLeftValueOfBinaryTreee {
	
	public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1] < depth){
           res[0]=root.val;
           res[1]=depth;
        }
        if (root.left != null){
           findBottomLeftValue(root.left, depth+1, res);
        }
        if (root.right != null){
           findBottomLeftValue(root.right, depth+1, res);
        }
        return res[0];
    }

}
