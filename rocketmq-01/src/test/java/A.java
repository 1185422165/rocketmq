public class A {

    /**
     * 爬楼梯
     *
     * @param n n
     * @return int
     */
    public int climbStairs(int n) {
        if (n == 0) return -1;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 0; i < n - 2; i++) {
            dp[i + 2] = dp[i] + dp[i + 1];
        }
        return dp[n - 1];
    }
}
