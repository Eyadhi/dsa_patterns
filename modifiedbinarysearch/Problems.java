package modifiedbinarysearch;

public class Problems {
    public static int searchInRotatedSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int minInRotatedSortedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] { 0, 0 };
            }
            return new int[] { -1, -1 };
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return findRange(nums, left, mid, right, target);
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    private static int[] findRange(int[] nums, int left, int mid, int right, int target) {
        int low = mid;
        int high = mid;
        while (low > left && nums[low - 1] == target) {
            low--;
        }

        while (high < right && nums[high + 1] == target) {
            high++;
        }
        return new int[] { low, high };
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(searchInRotatedSortedArray(nums, target));

        int[] nums2 = { 3, 4, 5, 1, 2 };
        System.out.println(minInRotatedSortedArray(nums2));

        int[] peak = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement(peak));

        int[] nums3 = { 5, 7, 7, 8, 8, 10 };
        int target2 = 8;
        int[] result = searchRange(nums3, target2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
