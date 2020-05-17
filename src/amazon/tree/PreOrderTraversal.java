package amazon.tree;

import java.util.*;

public class PreOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }

    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + " ");

            if (current.right != null) {
                stack.add(current.right);
            }

            if (current.left != null) {
                stack.add(current.left);
            }

        }

        return;

    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                /*
                 * place pointer to a tree node on the stack before traversing the node's left
                 * subtree
                 */
                stack.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = stack.pop();

            System.out.print(curr.val + " ");

            /*
             * we have visited the node and its left subtree. Now, it's right subtree's turn
             */
            curr = curr.right;

        }

    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || stack.size() > 0) {

            while(curr!=null){
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.val + " ");
            


        }

        return;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
    }

}