package rocks.whisperingchild.leetcode;

import rocks.whisperingchild.leetcode.primitive.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WhisperingChild on 18/06/2017.
 */
public class FindLargestValue_515 {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayList<TreeNode> current = new ArrayList<>();
        ArrayList<TreeNode> next = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            next.clear();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : current) {
                max = Math.max(max, node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            result.add(max);
            ArrayList<TreeNode> temp = current;
            current = next;
            next = temp;
        }
        return result;
    }
}
