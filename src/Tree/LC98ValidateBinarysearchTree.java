package Tree;
import java.util.*;
public class LC98ValidateBinarysearchTree {
    //Best solution
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (prev != null && prev >= root.val) return false;
        prev = root.val;
        return isValidBST(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //inorder traversal solution
    public boolean isValidBST2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(res, root);
        if (res.size() <= 1) return true;
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) return false;
        }
        return true;
    }

    private void traverse(List<Integer> res, TreeNode node) {
        if (node == null) return;
        traverse(res, node.left);
        res.add(node.val);
        traverse(res, node.right);

    }
    //standard dfs solution
    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        double min = Double.NEGATIVE_INFINITY;
        double max = Double.POSITIVE_INFINITY;
        return isValid(min, max, root);
    }

    private boolean isValid(double min, double max, TreeNode node){
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return isValid(min, node.val, node.left) && isValid(node.val, max, node.right);
    }

}
