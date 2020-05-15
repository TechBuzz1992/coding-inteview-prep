package amazon;

public class UniqueBSTs {
    public static void main(String[] args) {
        UniqueBSTs instance = new UniqueBSTs();

        System.out.println("Unique Tree For 3 nodes:"+instance.noOfUniqueBST(3));

    }

    public int noOfUniqueBST(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }

        return dp[n];
    }

}