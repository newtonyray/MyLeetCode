package Tree;
import java.util.*;
public class LC250UnivalueSubtrees {
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isUnival(root);
        return count;
    }

    private boolean isUnival(TreeNode node) {
        if (node == null) return true;
        boolean left = isUnival(node.left);
        boolean right = isUnival(node.right);
        if (left && right) {
            if (node.left != null && node.val != node.left.val
                    || node.right != null && node.val != node.right.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
