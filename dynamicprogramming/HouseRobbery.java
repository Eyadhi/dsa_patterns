package dynamicprogramming;

public class HouseRobbery {
    public static int robbery(int[] nums) {
        // int n = nums.length;
        // if (n == 1) return nums[0];

        // int[] dp =new int[n];
        // dp[0] =nums[0];
        // dp[1] = Math.max(nums[1],nums[0]);

        // for(int i=2;i<n;i++){
        // dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        // }
        // return dp[nums.length-1];

        int prev1 = 0; // dp[i - 1]
        int prev2 = 0; // dp[i - 2]

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 3, 4 };
        System.out.println(robbery(nums));
    }
}
