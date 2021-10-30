package labuladong.DynamicProgramming;
// **********************************//
// ***凑零钱算法--备忘录递归、dp迭代***//
// **********************************//

import java.util.Arrays;

public class CouLingQian {
    public int[] memo;

    // 带备忘录的递归
    public int coinChange(int[] coins, int amount){
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);

        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount){

        // base case
        if (amount==0) return 0;
        if (amount<0) return -1;

        // 查看备忘录，防止重复计算
        if (memo[amount] != -666) return memo[amount];

        int res = Integer.MAX_VALUE;

        for (int coin : coins){
            // the result of computing the subproblem
            int subproblem = dp(coins, amount-coin);

            // subproblem not result that continue
            if (subproblem == -1) continue;

            // selecting optimal solution on subProblems and plus 1 
            res = Math.min(res, subproblem+1);
        }

        memo[amount] = (res == Integer.MAX_VALUE) ? -1 :  res;
        return memo[amount];

    }


    
    // dp数组的迭代解法
    public int coinChanges(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);
    
        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new  int[]{1,2,5};
        int amount = 19;
        CouLingQian clq = new CouLingQian();
        // 备忘录递归
        int memo = clq.coinChange(coins, amount);
        System.out.println(memo);
        // dp迭代
        int dp = clq.coinChanges(coins, amount);
        System.out.println(dp);
    }
}