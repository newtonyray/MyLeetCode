package Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC106ConstructBinaryTreefromPostorderandInorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd) {
        if (postStart < 0 || inStart > inEnd) return null;
        //val for building cur node is postroder[postStart]
        TreeNode node = new TreeNode(postorder[postStart]);
        int nextHead = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) nextHead = i;
        }

        int rightTreeSize = inEnd - nextHead;
        node.left = build(inorder, postorder, postStart - rightTreeSize - 1, inStart, nextHead - 1);
        node.right = build(inorder, postorder, postStart - 1, nextHead + 1, inEnd);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
