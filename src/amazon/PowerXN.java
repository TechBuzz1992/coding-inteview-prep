package amazon;

/**
 * 
 * Complexity is O(logN)
 */

public class PowerXN {

    public static float pow(int x, int y) {
        float temp;
        if (y == 0) {
            return 1;
        }

        temp = pow(x, y / 2);

        if (y % 2 == 0) {
            return temp * temp;
        } else {
            if (y > 0) {
                return x * temp * temp;

            } else {
                return (temp * temp) / x;

            }

        }
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(pow(2,-4));
    }

}