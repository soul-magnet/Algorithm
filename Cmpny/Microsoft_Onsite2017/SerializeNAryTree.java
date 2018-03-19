package MS.Onsite2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**I think serializing the n-ary tree using BFS this way might work:

    1
  / | \
 2  3  4
   / \  \
  5   6  7
 can be serialized as:

 would like to suggest another one using DFS. The tree above could be serialized as :
 (1(2)(3(5)(6))(4(7)))
 Serialization :
 Depth first search of the tree. Each root is serialized as (root serialize(child1) serialize(child2) ...serialize(childn))
 Deserialization :

 Read charcter.
 1.1 If it is ''(", new node is added to current parent in the tree. Push it to a stack. The newly inserted node becomes current parent.
 1.2 If it is '')", pop from the stack. Parent is updated.
 Here is code for serialization and deserialization
 * Created by wtnwi on 2/24/2017.
 */
public class SerializeNAryTree {
    public class TreeNode{
        int val;
        List<TreeNode> children;

        public TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public void add(TreeNode node) {
            children.add(node);
        }

    }
    public  TreeNode deserialize(StringBuilder in)  {
        TreeNode root = null;
        TreeNode parent = null;
        Stack<TreeNode> stack = new Stack<>();
        int pos = 0;
        while  (pos < in.length()) {
            if (in.charAt(pos) == '(')  {
                pos ++;
                TreeNode node = new TreeNode(in.charAt(pos) -'0');
                if (parent == null)
                    root = node;
                else
                    parent.add(node);
                stack.push(node) ;
                parent = node;
            }
            else  if (in.charAt(pos) == ')')  {
                stack.pop();
                if (!stack.isEmpty())
                    parent = stack.peek();
            }
            pos++;
        }
        return root;
    }
    public String serialize(TreeNode root){
        StringBuilder out = new StringBuilder();
        serialize(root, out);
        return out.toString();
    }
    public void serialize(TreeNode root, StringBuilder out)  {
        if  (root != null)  {
            out.append('(');
            out.append(root.val);
            for  (TreeNode child : root.getChildren())  {
                serialize(child, out);
            }
            out.append(')');
        }
    }
}
