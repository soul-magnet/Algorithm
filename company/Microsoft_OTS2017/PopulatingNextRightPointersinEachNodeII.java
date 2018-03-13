package MS.OA2017;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 * Created by wtnwi on 1/12/2017.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        ArrayList<TreeLinkNode> level = new ArrayList<TreeLinkNode>();
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root); q.add(null);
        while(!q.isEmpty()){
            TreeLinkNode now = q.poll();
            if(now==null){
                if(level.size()==0){
                    break;
                }
                for(int i =0; i< level.size()-1;i++){
                    level.get(i).next = level.get(i+1);
                    //System.out.println( level.get(i).val +" "+ level.get(i).next.val);
                }
                if(q.isEmpty()){
                    break;
                }
                q.offer(null);
                level.clear();
                continue;
            }
            if (now.left != null) {
                q.offer(now.left);
                level.add(now.left);
            }
            if (now.right != null) {
                q.offer(now.right);
                level.add(now.right);
            }
        }
    }
    public static void main(String arg[]){
        PopulatingNextRightPointersinEachNodeII o = new PopulatingNextRightPointersinEachNodeII();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        o.connect(root);
        Queue<TreeLinkNode> q = new LinkedList<>();q.offer(root);
        while(!q.isEmpty()){
            TreeLinkNode now = q.poll();
           // System.out.println(now.next==null?"#":now.next.val);
            if (now.left != null) {
                q.offer(now.left);
            }
            if (now.right != null) {
                q.offer(now.right);
            }
        }
    }

}
