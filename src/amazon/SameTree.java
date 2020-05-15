package amazon;

public class SameTree {
    public static void main(String[] args) {

    }

    public boolean isSame(BTreeNode p, BTreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSame(p.left, q.left) && isSame(p.right, q.right);

    }

}