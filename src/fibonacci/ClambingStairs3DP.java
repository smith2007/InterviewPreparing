package fibonacci;

public class ClambingStairs3DP {

    public static void main(String[] args) {
        System.out.println(count(5));
    }

    static int count(int n) {

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];


    }
}
