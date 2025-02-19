// Time Complexity : O (n) (n = nodes in tree)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxValInTreeRow {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        // queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // result list
        List<Integer> maxValues = new ArrayList<>();
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            // iterate over this level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                // update the max value at this level as applicable
                if (max < curr.val) max = curr.val;
                // add curr's children to queue if not null
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            // add max to result list
            maxValues.add(max);
        }
        return maxValues;
    }
}
