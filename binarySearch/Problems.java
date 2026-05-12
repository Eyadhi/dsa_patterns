package binarySearch;

public class Problems {
    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left >= letters.length) {
            left = 0;
        }
        return letters[left];
    }

    public static boolean isRotatedSorted(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        if (nums[low] < nums[high])
            return true;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                for (int i = 0; i < n - 1; i++) {
                    int curr = (mid + i) % n;
                    int nextIdx = (curr + 1) % n;
                    if (nums[curr] > nums[nextIdx])
                        return false;
                }
                return true;
            }

            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr6 = { 3, 4, 5, 1, 2 };
        System.out.println(isRotatedSorted(arr6));
    }
}
