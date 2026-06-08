package dynamicprogramming.fibonaccinumber;

public class Problems {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
                
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n - 1];
    }

    public static int climbStairs1(int n) {
        if(n<=2)return n;

        int first = 1;
        int second = 2;

        for(int i=3;i<=n;i++){
            int sum = first+second;
            first = second;
            second =sum;
        }
        return second;
    }

    public static int houseRobbery(int[] nums) {
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
        System.out.println(climbStairs(3));

        int[] nums = { 2, 3, 1, 3, 4 };
        System.out.println(houseRobbery(nums));
    }
}
