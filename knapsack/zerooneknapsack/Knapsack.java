package knapsack.zerooneknapsack;

public class Knapsack {
    public static int solveKnapsack(int[] profits,int[] weights,int capacity){
        int n=profits.length;
        int[][] dp = new int[n][capacity+1];

        for(int c=0;c<=capacity;c++){
            if(weights[0]<=c){
                dp[0][c] = profits[0];
            }
        }

        for(int i=1;i<n;i++){
            int profit1 = 0;
            int profit2 = 0;
            for(int c = 1;c<=capacity;c++){
                if(weights[i]<=c){
                    profit1 = profits[i]+dp[i-1][c-weights[i]];
                }
                profit2 = dp[i-1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        return dp[n-1][capacity];
    }

    public static int solveKnapsack1(int[] profits,int[] weights,int capacity){
        int n=profits.length;
        int[] dp = new int[capacity+1];

        for(int i=0;i<n;i++){
            for(int c = capacity;c>=weights[i];c--){
                dp[c] = Math.max(dp[c], profits[i]+dp[c-weights[i]]);
            }
        }
        return dp[capacity];
    }


    public static boolean canPartition(int[] nums) {
        int sum =0;
        for(int num:nums){
            sum+= num;
        }

        if(sum%2!=0)return false;

        int target = sum/2;
        int n=nums.length;

        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean exclude = dp[i-1][j];
                boolean include = false;
                if(nums[i]<=j){
                    include = dp[i-1][j-nums[i]];
                }

                dp[i][j] = exclude || include;
            }
        }
        return dp[n-1][target];
    }

    public static boolean canPartition1(int[] nums){
        int sum =0;
        for(int num:nums){
            sum+= num;
        }

        if(sum%2!=0)return false;

        int target = sum/2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num:nums){
            for(int c=target;c>=num;c--){
                dp[c] = dp[c] || dp[c-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        int result = solveKnapsack1(profits, weights, 7);

        System.out.println(result); // 22

        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
