package Tree;

import java.util.*;

public class LC99RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        traverse(res, root);
        if (res.size() <= 1) return;
        TreeNode first = null;
        TreeNode second = null;
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).val >= res.get(i + 1).val) {
                if (first == null) first = res.get(i);
                second = res.get(i + 1);
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(List<TreeNode> res, TreeNode node) {
        if (node == null) return;
        traverse(res, node.left);
        res.add(node);
        traverse(res, node.right);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
