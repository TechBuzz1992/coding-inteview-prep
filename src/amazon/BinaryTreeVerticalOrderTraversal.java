package amazon;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

    }

    public List<List<Integer>> getVerticalOrderTraversal(TreeNode root) {

        Queue<TreeNode> queueNodes = new LinkedList<>();
        Queue<Integer> queueCols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        queueNodes.add(root);
        queueCols.add(0);

        int min = 0;
        int max = 0;

        while (!queueNodes.isEmpty()) {
            TreeNode current = queueNodes.poll();
            int col = queueCols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }

            map.get(col).add(current.val);

            if (current.left != null) {
                queueCols.add(col - 1);
                queueNodes.add(current.left);
                min = Math.min(min, col - 1);
            }

            if (current.right != null) {
                queueNodes.add(current.right);
                queueCols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for(int i=min;i<=max;i++){
            result.add(map.get(i));
        }

        return result;

    }

}