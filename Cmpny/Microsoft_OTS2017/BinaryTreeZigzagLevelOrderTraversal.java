package MS.OA2017;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wtnwi on 1/15/2017.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resArrayList = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return resArrayList;
        }
        Stack<TreeNode> now = new Stack<TreeNode>(), next = new Stack<TreeNode>();
        now.push(root);

        boolean order = true;

        while (!now.isEmpty() || !next.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<Integer>();
            while (!now.isEmpty()) {
                TreeNode node = now.pop();
                if (order) {
                    if (node.left != null) {
                        next.push(node.left);
                    }
                    if (node.right != null) {
                        next.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        next.push(node.right);
                    }
                    if (node.left != null) {
                        next.push(node.left);
                    }
                }

                layer.add(node.val);
            }
            resArrayList.add(layer);
            order = !order;
            Stack<TreeNode> temp = now;
            now = next;
            next=temp;
        }
        return resArrayList;


    }
}
