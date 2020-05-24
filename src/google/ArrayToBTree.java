package google;

/import java.util.*;

public class ArrayToBTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.left = this.right = null;
            this.val = x;
        }
    }

    public static void main(String[] args) {

    }

    public TreeNode constructBTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructBTreeRecursive(nums, 0, nums.length - 1);

    }

    public TreeNode constructBTreeRecursive(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBTreeRecursive(nums, left, mid - 1);
        current.right = constructBTreeRecursive(nums, mid + 1, right);
        return current;

    }

}