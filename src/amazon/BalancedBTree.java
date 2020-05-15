package amazon;

class Node{
    int val;
    Node left;
    Node right;
    Node(int x){
        this.val = x;
    }

}

public class BalancedBTree {

    boolean isBalanced = true;
    public static void main(String[] args) {
        
    }

    boolean isTreeBalanced(Node root){
        height(root);
        return isBalanced;

    }

    int height(Node root){

        if(root == null){
            return 0;
        }

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if(Math.abs(lHeight - rHeight) > 1){
            isBalanced = false;
        }

        return 1+ Math.max(lHeight,rHeight);


    }


    
}