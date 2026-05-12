package divideandconquer;

public class MaxSubarray {

    // Compute maximum crossing subarray sum for arr[left..mid..right]
    private static int maxCrossingSum(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int leftMax = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        sum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        // both sides non-empty, safe to add
        return leftMax + rightMax;
    }

    // Recursive divide & conquer to compute max subarray sum in arr[left..right]
    private static int maxSubArraySumRec(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;

        // max in left half
        int leftMax = maxSubArraySumRec(arr, left, mid);

        // max in right half
        int rightMax = maxSubArraySumRec(arr, mid + 1, right);

        // max crossing mid
        int crossMax = maxCrossingSum(arr, left, mid, right);

        // return maximum of leftMax, rightMax, crossMax without using Math.max
        int tempMax = leftMax;
        if (rightMax > tempMax)
            tempMax = rightMax;
        if (crossMax > tempMax)
            tempMax = crossMax;
        return tempMax;
    }

    // Public API
    public static int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0; // defined behavior for empty array
        return maxSubArraySumRec(arr, 0, arr.length - 1);
    }

    // Main: prints only the output (the maximum sum)
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = maxSubArraySum(arr);
        System.out.println(result); // Expected output: 6
    }
}
