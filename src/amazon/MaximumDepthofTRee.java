package amazon;

public class MaximumDepthofTRee {
    public static void main(String[] args) {
        
    }

    public int maxDepth(BTreeNode root){
        if(root == null){
            return 0;
        }

        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    
}