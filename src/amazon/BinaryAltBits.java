package amazon;

public class BinaryAltBits {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new BinaryAltBits().isAltBits(n));

    }

    public boolean isAltBits(int n) {
        int previous = n % 2;
        n >>= 1;
        int current = 0;
        while (n > 0) {
            current = n % 2;

            if (current == previous) {
                return false;
            }

            previous = current;
            n >>= 1;
        }

        return true;

    }

}