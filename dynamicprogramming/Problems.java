package dynamicprogramming;

public class Problems {
	public static int sequence(int arr[]) {
		int pre1 = arr[0];
		int pre2 = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			int temp = pre2;
			pre2 = Math.max(pre1 + arr[i], pre2);
			pre1 = temp;
		}
		return pre2;
	}

	public static int maxSubArray(int[] arr) {
		int max = arr[0];
		int newsum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			newsum = Math.max(arr[i], newsum + arr[i]);
			max = Math.max(max, newsum);
		}
		return max;
	}

	public static int maxProductSub(int nums[]) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxProd = nums[0];
		int minProd = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];
			if (curr < 0) {
				int temp = maxProd;
				maxProd = minProd;
				minProd = temp;
			}
			maxProd = Math.max(curr, curr * maxProd);
			minProd = Math.min(curr, curr * minProd);

			result = Math.max(result, maxProd);
		}
		return result;
	}

	public static int removeDuplicates(int arr[]) {
		if (arr.length <= 2)
			return arr.length;
		int prev = 1;
		int curr = 2;
		while (curr < arr.length) {
			if (arr[curr] == arr[prev] && arr[curr] == arr[prev - 1]) {
				curr++;
			} else {
				prev++;
				arr[prev] = arr[curr];
				curr++;
			}
		}
		return prev + 1;
	}

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

    static int specFibo(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return specFibo(n - 1) * specFibo(n - 1) + specFibo(n - 2) * specFibo(n - 2);
    }

	public static void main(String[] args) {
		int arr[] = { 2, 3, -2, 4 };
		int result = sequence(arr);
		System.out.println(result);

		System.out.println(maxSubArray(arr));

		System.out.println(maxProductSub(arr));
		
		int[] arr1 = { 1, 1, 1, 2 };
		System.out.println(removeDuplicates(arr1));

		int n = 3;
        System.out.println(climbStairs(n));

		int[] nums = { 2, 3, 1, 3, 4 };
        System.out.println(houseRobbery(nums));

		int n1 = 10;
        int result1 = fibonacci(n1);
        System.out.println("The " + n + "th Fibonacci number is: " + result1);

        int[] res = new int[n1];
        res = fibonacci1(n1);
        for (int i = 0; i < n1; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println(specFibo(2));
	}
}
