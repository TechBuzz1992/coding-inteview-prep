package coding_patterns;

import java.util.*;

public class HeightOfTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public int getHeight(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int height = 0;
        queue.add(root);
        int curreSize = 0;
        while (!queue.isEmpty()) {
            height++;
            curreSize = queue.size();
            for (int i = 0; i < curreSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

        }

        return height-1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);

        HeightOfTree obj = new HeightOfTree();
        System.out.println(obj.getHeight(root));

    }

}