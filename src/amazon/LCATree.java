package amazon;

public class LCATree {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public static void main(String[] args) {

    }

    public TreeNode lcaTree(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && root.val < q.val) {
            return lcaTree(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lcaTree(root.left, p, q);
        }

        return root;

    }

}