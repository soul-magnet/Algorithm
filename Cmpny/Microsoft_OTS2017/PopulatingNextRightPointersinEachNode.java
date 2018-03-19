package MS.OA2017;

/**https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 Subscribe to see which companies asked this question
 * Created by wtnwi on 1/12/2017.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        // �սڵ��ֱ�ӷ���
        if(root == null){
            return;
        }

        // ��ڵ�ǿգ������ҽڵ�
        if(root.left != null){
            root.left.next = root.right;
        }

        // ����root.next����5��6�����
        if(root.right!=null && root.next!=null){
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }
}
