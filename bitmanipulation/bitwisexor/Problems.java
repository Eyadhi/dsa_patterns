package bitmanipulation.bitwisexor;

public class Problems {
    public static boolean evenOrOdd(int n){
        if((n^1)== n+1){
            return true;
        }else{
            return false;
        }
    }
    
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    public int singleNumber11(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }
        return one;
    }

    public int[] singleNumber111(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int rightMostBit = xor & (-xor);

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & rightMostBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] { a, b };
    }

    public static int xorTillN(int n){
        if(n%4 == 0)return n;
        if(n%4 == 1)return 1;
        if(n%4 == 2)return n+1;
        return 0;
    }

    public static void main(String[] args) {

    }
}
