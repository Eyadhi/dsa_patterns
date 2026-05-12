package bitmanipulation;

public class BitProblem {
    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public static boolean isPowerOfTwo(int n) {
        // if (n <= 0)
        // return false;
        // return (n & (n - 1)) == 0;
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEven(6));
        System.out.println(isPowerOfTwo(8));
    }
}
