package dynamicprogramming;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        int[] stairs = new int[n];
        if (n == 1) {
            return 1;
        }
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n - 1];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
}
