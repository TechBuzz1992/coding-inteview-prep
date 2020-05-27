package amazon;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    static class TreeNode {

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
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);
        root.right.left.right.left = new TreeNode(7);

        BinaryTreeVerticalOrderTraversal obj  = new BinaryTreeVerticalOrderTraversal();
       
        List<List<Integer>> vOrderList = obj.getVerticalOrderTraversal(root);

        for(List<Integer> ls : vOrderList){
            System.out.println(ls);
        }

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