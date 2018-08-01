package Tree;

public class LC105ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int nextRootIdx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) nextRootIdx = i;
        }
        //after we find the nextRootIdx in inorder array, split
        node.left = build(preorder, inorder, preStart + 1, inStart, nextRootIdx - 1);
        //for right side, the most important thing is to find the preStart offset
        int leftSubtreeSize = nextRootIdx - 1 - inStart + 1;
        node.right = build(preorder, inorder, preStart + leftSubtreeSize + 1, nextRootIdx + 1, inEnd);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //standard dfs solution
    public boolean isValidBST(TreeNode root) {
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
