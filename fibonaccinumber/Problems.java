package fibonaccinumber;

public class Problems {
    public static int climbStairs(int n) {
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

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
