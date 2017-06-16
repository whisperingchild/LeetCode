package rocks.whisperingchild.leetcode.experiment;

import rocks.whisperingchild.leetcode.primitive.TreeNode;

/**
 * Created by whisperingchild on 16/06/2017.
 */
public class MergeTwoBST {
    public TreeNode merge(TreeNode node1, TreeNode node2) {
        return null;
    }

    public void treeToLinkList(TreeNode node, TreeNode[] nodes) {
        nodes[0] = node;
        nodes[1] = node;
        if (node.left != null) {
            TreeNode[] leftNodes = new TreeNode[2];
            treeToLinkList(node.left, leftNodes);
            leftNodes[1].right = node;
            node.left = leftNodes[1];
            nodes[0] = leftNodes[0];
        }

        if (node.right != null) {
            TreeNode[] rightNodes = new TreeNode[2];
            treeToLinkList(node.right, rightNodes);
            rightNodes[0].left = node;
            node.right = rightNodes[0];
            nodes[1] = rightNodes[1];
        }
    }

    public TreeNode mergeTwoLinkList(TreeNode node1, TreeNode node2) {
        TreeNode head = new TreeNode();
        TreeNode tail = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.right = node1;
                node1.left = tail;
                tail = node1;
                node1 = node1.right;
            }
            else {
                tail.right = node2;
                node2.left = tail;
                tail = node2;
                node2 = node2.right;
            }
        }

        if (node1 == null) {
            tail.right = node2;
            node2.left = tail;
        }
        else {
            tail.right = node1;
            node1.left = tail;
        }

        head = head.right;
        head.left = null;
        return head;
    }
}
