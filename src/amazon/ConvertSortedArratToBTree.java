package amazon;

class BTreeNode {
    int val;
    BTreeNode left;
    BTreeNode right;
    BTreeNode next;

    BTreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

public class ConvertSortedArratToBTree {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }

    public BTreeNode getTreeNode(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        BTreeNode root = helper(nums, 0, nums.length - 1);

        return root;

    }

    public BTreeNode helper(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;

            BTreeNode current = new BTreeNode(nums[mid]);
            current.left = helper(nums, start, mid - 1);
            current.right = helper(nums, mid + 1, end);

            return current;

        }

        return null;
    }

}