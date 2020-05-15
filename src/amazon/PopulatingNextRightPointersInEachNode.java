package amazon;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {

    }

    public void connect(BTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BTreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            BTreeNode temp = null;

            for (int i = 0; i < levelSize; i++) {
                BTreeNode current = queue.remove();
                current.next = temp;
                temp = current;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

            }

        }

    }

}