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

        return ans;package coding_patterns;

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
        
            public List<Integer> getTreeLeftView(TreeNode root){
                List<List<Integer>> levelOrder = getLevelOrderTraversal(root);
                List<Integer> leftViewList = new ArrayList<Integer>();
                for(List<Integer> ls:levelOrder){
                    leftViewList.add(ls.get(0));
                }
        
                return leftViewList;
            }
        
            public List<Integer> getTreeRightView(TreeNode root){
                List<List<Integer>> levelOrder = getLevelOrderTraversal(root);
                List<Integer> rightViewList = new ArrayList<Integer>();
                for(List<Integer> ls : levelOrder){
                    rightViewList.add(ls.get(ls.size()-1));
                }
                return rightViewList;
            }
        
            public static void main(String[] args) {
                TreeNode root = new TreeNode(0);
                root.left = new TreeNode(1);
                root.right = new TreeNode(2);
                root.left.left = new TreeNode(3);
                root.left.right = new TreeNode(4);
                root.right.left = new TreeNode(5);
                root.right.right = new TreeNode(6);
        
                LeftRightViewTree obj = new LeftRightViewTree();
                List<List<Integer>> list = obj.getLevelOrderTraversal(root);
        
                for (List<Integer> ls : list) {
                    System.out.println(ls);
                }
            }
        
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        LeftRightViewTree obj = new LeftRightViewTree();
        List<List<Integer>> list = obj.getLevelOrderTraversal(root);

        for (List<Integer> ls : list) {
            System.out.println(ls);
        }
    }

}