package dynamicprogramming.fibonaccinumber;

public class FibonacciNumber {
    static int[] dp;

    //Memorization (Top Down)
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        dp[n] = fibonacci(n-1)+fibonacci(n-2);
        return dp[n];
    }

    // Tabulation (Bottom Up)
    public static int fibonacci1(int n) {
        if(n<=1){
            return n;
        }

        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    // Space Optimized Dp
    public static int fibonacciSpaceOptimized(int n) {
        if(n<=1){
            return n;
        }

        int prev2= 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev1+prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }   

    public static void main(String[] args) {
        int n = 10;
        int result = fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
