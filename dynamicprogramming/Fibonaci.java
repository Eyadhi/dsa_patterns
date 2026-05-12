package techniques.dynamicprogramming;

public class Fibonaci {
    public static int fibonacci(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    public static int[] fibonacci1(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    static int SpecFibo(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return SpecFibo(n - 1) * SpecFibo(n - 1) + SpecFibo(n - 2) * SpecFibo(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        int result = fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
        int[] res = new int[n];
        res = fibonacci1(n);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println(SpecFibo(2));
    }
}