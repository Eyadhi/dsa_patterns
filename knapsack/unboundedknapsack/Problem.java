package knapsack.unboundedknapsack;

class Problem{
    public static int maxProfit(int[] profit,int[] weight,int capacity){
        int n = profit.length;

        int[][] dp =  new int[n][capacity+1];

        for(int i=0;i<n;i++){
            for(int j=1;j<=capacity;j++){
                int exclude = 0;
                int include = 0;

                 if(i>0){
                    exclude = dp[i-1][j];
                }
                if(weight[i]<=j){
                    include = profit[i]+dp[i][j-weight[i]];
                }
                dp[i][j]=Math.max(include,exclude);
            }
        }
        return dp[n-1][capacity];
    } 

    public static int maxProfit1(int[] profit,int[] weight,int capacity){
        int n = profit.length;

        int[] dp =  new int[capacity+1];

        for(int c=0;c<=capacity;c++){
            if(weight[0]<=c){
                dp[c] = profit[0];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=weight[i];j<=capacity;j++){
                dp[j]=Math.max(dp[j],(profit[i]+dp[j-weight[i]]));
            }
        }
        return dp[capacity];
    } 

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount+1;

        int[][] dp =  new int[n][amount+1];

        for(int i=0;i<n;i++){
            for(int j=1;j<=amount;j++){
                dp[i][j] = INF;
            }
        }

        for(int j=1;j<=amount;j++){
            if(j%coins[0] == 0){
                dp[0][j] = j/coins[0];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int exclude = dp[i-1][j];
                int include = INF;

                if(coins[i]<=j){
                    include = 1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(include,exclude);
            }
        }
        
        return dp[n-1][amount] == INF?-1:dp[n-1][amount];
    }

    public static int coinChangeOptimized(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount+1;

        int[] dp =  new int[amount+1];

        for(int j=1;j<=amount;j++){
            dp[j] = INF;
        }

        for(int j=1;j<=amount;j++){
            if(j%coins[0] == 0){
                dp[j] = j/coins[0];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int exclude = dp[j];
                int include = INF;

                if(coins[i]<=j){
                    include = 1+dp[j-coins[i]];
                }
                dp[j]=Math.min(include,exclude);
            }
        }
        
        return dp[amount] == INF?-1:dp[amount];
    }

    public static int coinChange11(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp =  new int[n][amount+1];

        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=amount;j++){
            if(j%coins[0] == 0){
                dp[0][j] = 1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int exclude = dp[i-1][j];
                int include = 0;

                if(coins[i]<=j){
                    include = dp[i][j-coins[i]];
                }
                dp[i][j]=include+exclude;
            }
        }
        
        return dp[n-1][amount];
    }

    public static int coinChange11Optimized(int[] coins, int amount) {
        int n = coins.length;

        int[] dp =  new int[amount+1];
        dp[0]=1;

        for(int j=1;j<=amount;j++){
            if(j%coins[0] == 0){
                dp[j] = 1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int exclude = dp[j];
                int include = 0;

                if(coins[i]<=j){
                    include = dp[j-coins[i]];
                }
                dp[j]=include+exclude;
            }
        }
        
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};

        int result = maxProfit(profits, weights, 8);

        System.out.println(result); // 140

        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChangeOptimized(coins,amount)); // 11

        int[] coins1 = {1,2,5};
        int amount1 = 5;
        System.out.println(coinChange11(coins1,amount1)); // 4

    }
}