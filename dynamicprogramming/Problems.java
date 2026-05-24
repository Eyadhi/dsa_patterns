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

        System.out.println(specFibo(2));
	}
}
