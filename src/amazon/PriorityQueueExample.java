package amazon;

import java.util.*;

class TreeNode {
    int val;
    TreeNode next;

    TreeNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class PriorityQueueExample {
    public static void main(String[] args) {

        Comparator<TreeNode> nodeComparator = new Comparator<TreeNode>(){
            public int compare(TreeNode node1, TreeNode node2){
                return node1.val - node2.val;
            }
        };

        PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>(nodeComparator);

        queue.add(new TreeNode(345));
        queue.add(new TreeNode(945));
        queue.add(new TreeNode(145));
        queue.add(new TreeNode(45));
        queue.add(new TreeNode(445));
        queue.add(new TreeNode(245));
        queue.add(new TreeNode(385));

        while(!queue.isEmpty()){
            System.out.println(queue.poll().val);
        }


    }

}