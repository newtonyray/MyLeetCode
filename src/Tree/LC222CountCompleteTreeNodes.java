package Tree;
import java.util.*;
public class LC222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        while (root != null) {
            int height = getHeight(root);
            if (getHeight(root.right) == height - 1) {
                count += 1 << height - 1;
                root = root.right;
            } else {
                count += 1 << height - 2;
                root = root.left;
            }
        }
        return count;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + getHeight(node.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
