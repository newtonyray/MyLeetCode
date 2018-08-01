package GGL;

public class LC124BinaryTreeMaximumPathSum {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findPathMax(root);
        return maxSum;
    }

    public int findPathMax(TreeNode root){
        if(root == null) return 0;
        int leftSum =  Math.max(0,findPathMax(root.left));
        int rightSum =  Math.max(0,findPathMax(root.right));
        maxSum = Math.max(maxSum,leftSum+rightSum+root.val);
        return Math.max(leftSum,rightSum)+root.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
