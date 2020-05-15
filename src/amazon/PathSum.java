package amazon;

public class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public boolean pathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;

        }

        return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);

    }

}