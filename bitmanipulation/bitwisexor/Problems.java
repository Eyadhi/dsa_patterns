package bitmanipulation.bitwisexor;

public class Problems {
    public int singleNumber(int[] nums) {
        int result =0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }

    public void swap(int a,int b){
        a = a^b;
        b = a^b;
        a = a^b;
    }

    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    public int singleNumber(int[] nums) {
        int one =0;
        int two =0;
        for(int num:nums){
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }
        return one;
    }

    public static void main(String[] args){
        
    }
}
