package coding_patterns;

import java.util.*;

public class LeftRightViewTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    static class Height {
        int height = 0;
    }

    public List<List<Integer>> getLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            int currentLevel = queue.size();
            List<Integer> currentList = new ArrayList<Integer>();
            for (int i = 0; i < currentLevel; i++) {
                TreeNode current = queue.poll();
                currentList.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            ans.add(currentList);
        }

        return ans;

    }

    public List<Integer> getTreeLeftView(TreeNode root) {
        List<List<Integer>> levelOrder = getLevelOrderTraversal(root);
        List<Integer> leftViewList = new ArrayList<Integer>();
        for (List<Integer> ls : levelOrder) {
            leftViewList.add(ls.get(0));
        }

        return leftViewList;
    }

    public List<Integer> getTreeRightView(TreeNode root) {
        List<List<Integer>> levelOrder = getLevelOrderTraversal(root);
        List<Integer> rightViewList = new ArrayList<Integer>();
        for (List<Integer> ls : levelOrder) {
            rightViewList.add(ls.get(ls.size() - 1));
        }
        return rightViewList;
    }

    public int getDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameter = 0;
        List<List<Integer>> levelOrder = getLevelOrderTraversal(root);
        for (int i = 0; i < levelOrder.size(); i++) {
            diameter = Math.max(diameter, levelOrder.get(i).size());
        }

        return diameter;

    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        List<List<Integer>> list = getLevelOrderTraversal(root);

        return list.size();
    }

    public boolean isSumTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode current = queue.poll();
            int left = current.left != null ? current.left.val : 0;
            int right = current.right != null ? current.right.val : 0;
            if (left == 0 && right == 0) {
                continue;
            }
            if (current.val != left + right) {
                return false;
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }

        }

        return true;

    }

    public boolean isBalanced(TreeNode root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean l = isBalanced(root.left, lHeight);
        boolean r = isBalanced(root.right, rHeight);

        int lH = lHeight.height;
        int rH = rHeight.height;

        height.height = Math.max(lH, rH) + 1;

        if (Math.abs(lH - rH) >= 2) {
            return false;
        }

        else {
            return l && r;
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
        //root.right.left.right.left.right = new TreeNode(7);
        // root.right.right = new TreeNode(6);

        LeftRightViewTree obj = new LeftRightViewTree();
        List<List<Integer>> list = obj.getLevelOrderTraversal(root);

        for (List<Integer> ls : list) {
            System.out.println(ls);
        }

        List<Integer> leftView = obj.getTreeLeftView(root);
        List<Integer> rightView = obj.getTreeRightView(root);
        System.out.println("Tree Left View : " + leftView);
        System.out.println("Tree Right View : " + rightView);
        System.out.println("Tree Diameter is : " + obj.getDiameter(root));
        System.out.println("Tree height is : " + obj.getHeight(root));

        TreeNode root1 = new TreeNode(12);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(5);
        System.out.println("Tree isSum Tree ? : " + obj.isSumTree(root1));
        System.out.println("Is Tree balanced ? : " + obj.isBalanced(root, new Height()));

    }

}