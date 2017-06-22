package rocks.whisperingchild.leetcode.experiment;

import rocks.whisperingchild.leetcode.primitive.TreeNode;

/**
 * Created by WhisperingChild on 16/06/2017.
 */
public class MergeTwoBST {
    public TreeNode merge(TreeNode node1, TreeNode node2) {
        return null;
    }

    private TreeNode rightRotate(TreeNode root) {
        if (root.left == null) return root;
        TreeNode left = root.left;
        TreeNode leftRight = left.right;
        root.left = leftRight;
        left.right = root;
        return left;
    }

    private TreeNode leftRotate(TreeNode root) {
        return root;
    }

    private TreeNode toRightVine (TreeNode root) {
        while (root.left != null) {
            root = rightRotate(root);
        }
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                node = rightRotate(node);
            }
            node = node.right;
        }
        return root;
    }

    private int countRightVine(TreeNode root) {
        int count = 0;
        while (root != null) {
            ++count;
            root = root.right;
        }
        return count;
    }

    private TreeNode toLeftTree(TreeNode root) {
        int count = countRightVine(root);
        int times = (int) (Math.log(count) / Math.log(2.0));
        TreeNode node = root;
        for (int i = times; i > 0; --i) {
            node = leftRotate(node);
            root = node.right;
            for (int j = count / 2 - 1; j > 0; --j) {
                root = leftRotate(root);
                root = root.right;
            }
            count >>>= 1;
        }
        return node;
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
        TreeNode head = new TreeNode(0);
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
